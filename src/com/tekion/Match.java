package com.tekion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Match {
    private Team A;
    private Team B;
    private Map<String, Integer> firstInnings;
    private Map<String, Integer> secondInnings;

    public Match(Team A, Team B){
        this.A = A;
        this.B = B;
        firstInnings = new LinkedHashMap<>();
        secondInnings = new LinkedHashMap<>();
    }

    public void setFirstInnings(Team firstTeam, Team secondTeam) {
        for(Player batsman: firstTeam.getBatsmen()){
            firstInnings.put(batsman.getName(), batsman.getRuns());
        }
        for(Player bowler: firstTeam.getBowlers()){
            firstInnings.put(bowler.getName(), bowler.getRuns());
        }
        for(Player bowler: secondTeam.getBowlers()){
            firstInnings.put(bowler.getName(), bowler.getWickets());
        }
    }
    public Map<String, Integer> getFirstInnings(){
        return firstInnings;
    }
    public void setSecondInnings(Team secondTeam, Team firstTeam) {
        for(Player batsman: secondTeam.getBatsmen()){
            secondInnings.put(batsman.getName(), batsman.getRuns());
        }
        for(Player bowler: secondTeam.getBowlers()){
            secondInnings.put(bowler.getName(), bowler.getRuns());
        }
        for(Player bowler: firstTeam.getBowlers()){
            secondInnings.put(bowler.getName(), bowler.getWickets());
        }
    }
    public Map<String, Integer> getSecondInnings(){
        return secondInnings;
    }
    public boolean validBatsman(int ind){
        if(ind<A.getBatsmen().size()){
            return true;
        }
        return false;
    }
    public boolean validBowlerAsBatsman(int ind){
        if(ind<A.getBowlers().size()){
            return true;
        }
        else{
            return false;
        }
    }
    public void batting(Team team){
        Team batTeam;
        Team bowlTeam;
        if(team.equals(A)){
            batTeam = A;
            bowlTeam = B;
        }
        else{
            batTeam = B;
            bowlTeam = A;
        }
        int totalMembers = batTeam.getBatsmen().size()+batTeam.getBowlers().size();
        int noOfBowlers = bowlTeam.getBowlers().size();
        Scanner sc = new Scanner(System.in);
        int wicketPerOver=0;
        int teamWickets=0;
        int teamRuns=0;
        int ballsPerOver = 0;
        int totalBalls=0;
        int currBatsman = 0;
        int currBowlerAsBatsman=0;
        int prevBowler = -1;
        int runsPerBatsman = 0;
        int currBowler = (int) (Math.random() * noOfBowlers);
        Player bowler;
        Player batsman = batTeam.getBatsmen().get(currBatsman);
        do {
            while (currBowler == prevBowler) {
                currBowler = (int) (Math.random() * noOfBowlers);
            }
            bowler = bowlTeam.getBowlers().get(currBowler);
            while (ballsPerOver != 6 && teamWickets!=totalMembers) {
                ballsPerOver++;
                totalBalls++;
                int val = (int)(Math.random()*8);
//                int val = sc.nextInt();
//                System.out.print(val+" ");
                if(val==7){                            //Wicket!!
                    wicketPerOver++;
                    teamWickets++;
                    batsman.setRuns(runsPerBatsman);
                    runsPerBatsman = 0;
                    if(currBatsman==batTeam.getBatsmen().size()){
                        currBowlerAsBatsman++;
                    }
                    else{
                        currBatsman++;
                    }
                    if(validBatsman(currBatsman)){
                        batsman = batTeam.getBatsmen().get(currBatsman);
                    }
                    else if(validBowlerAsBatsman(currBowlerAsBatsman)){
                        batsman = batTeam.getBowlers().get(currBowlerAsBatsman);
                    }
                }
                else{
                    int runPerBall = batsman.run();
                    runsPerBatsman = runsPerBatsman+runPerBall;
                    teamRuns = teamRuns+runPerBall;
                }
            }
            bowler.setWickets(bowler.getWickets()+wicketPerOver);
            wicketPerOver = 0;
            ballsPerOver = 0;
            prevBowler = currBowler;

        } while (teamWickets!=totalMembers && totalBalls!=batTeam.getOvers()*6);
        if(currBowlerAsBatsman!=noOfBowlers) {
            batsman.setRuns(runsPerBatsman);
        }
        batTeam.setRuns(teamRuns);
        batTeam.setWicket(teamWickets);
        if(batTeam==A) {
            setFirstInnings(batTeam, bowlTeam);
        }
        else{
            setSecondInnings(batTeam, bowlTeam);
        }
    }
    public void result() {
        if(A.getRuns()>B.getRuns()){
            System.out.println("Winning team is "+A.getName());
        }
        else if (A.getRuns()<B.getRuns()){
            System.out.println("Winning team is "+B.getName());
        }
        else{
            System.out.println("Match is drawn");
        }
    }


//    public void firstTeamBatting(){
//        int totalMembers = A.getBatsmen().size()+A.getBowlers().size();
//        int noOfBowlers = B.getBowlers().size();
//        Scanner sc = new Scanner(System.in);
//        int wicketPerOver=0;
//        int teamWickets=0;
//        int teamRuns=0;
//        int ballsPerOver = 0;
//        int totalBalls=0;
//        int currBatsman = 0;
//        int currBowlerAsBatsman=0;
//        int prevBowler = -1;
//        int runsPerBatsman = 0;
//        int currBowler = (int) (Math.random() * noOfBowlers);
//        Player bowler;
//        Player batsman = A.getBatsmen().get(currBatsman);
//        do {
//            while (currBowler == prevBowler) {
//                currBowler = (int) (Math.random() * noOfBowlers);
//            }
//            bowler = B.getBowlers().get(currBowler);
//            while (ballsPerOver != 6) {
//                ballsPerOver++;
//                totalBalls++;
//                int val = (int)(Math.random()*8);
////                int val = sc.nextInt();
////                System.out.print(val+" ");
//                if(val==7){                            //Wicket!!
//                    wicketPerOver++;
//                    teamWickets++;
//                    batsman.setRuns(runsPerBatsman);
//                    runsPerBatsman = 0;
//                    if(currBatsman==A.getBatsmen().size()){
//                        currBowlerAsBatsman++;
//                    }
//                    else{
//                        currBatsman++;
//                    }
//                    if(validBatsman(currBatsman)){
//                        batsman = A.getBatsmen().get(currBatsman);
//                    }
//                    else if(validBowlerAsBatsman(currBowlerAsBatsman)){
//                        batsman = A.getBowlers().get(currBowlerAsBatsman);
//                    }
//                }
//                else{
//                    int runPerBall = batsman.run();
//                    runsPerBatsman = runsPerBatsman+runPerBall;
//                    teamRuns = teamRuns+runPerBall;
//                }
//            }
//            bowler.setWickets(bowler.getWickets()+wicketPerOver);
//            wicketPerOver = 0;
//            ballsPerOver = 0;
//            prevBowler = currBowler;
//
//        } while (teamWickets!=totalMembers && totalBalls!=A.getOvers()*6);
//        batsman.setRuns(runsPerBatsman);
//        A.setRuns(teamRuns);
//        A.setWicket(teamWickets);
//        setFirstInnings();
//    }
//    public void secondTeamBatting(){
//        int totalMembers = B.getBatsmen().size()+B.getBowlers().size();
//        int noOfBowlers = A.getBowlers().size();
//        Scanner sc = new Scanner(System.in);
//        int wicketPerOver=0;
//        int teamWickets=0;
//        int teamRuns=0;
//        int ballsPerOver = 0;
//        int totalBalls=0;
//        int currBatsman = 0;
//        int currBowlerAsBatsman=0;
//        int prevBowler = -1;
//        int runsPerBatsman = 0;
//        int currBowler = (int) (Math.random() * noOfBowlers);
//        Player bowler;
//        Player batsman = B.getBatsmen().get(currBatsman);
//        do {
//            while (currBowler == prevBowler) {
//                currBowler = (int) (Math.random() * noOfBowlers);
//            }
//            bowler = A.getBowlers().get(currBowler);
//            while (ballsPerOver != 6) {
//                ballsPerOver++;
//                totalBalls++;
//                int val = (int)(Math.random()*8);
////                int val = sc.nextInt();
////                System.out.print(val+" ");
//                if(val==7){                            //Wicket!!
//                    wicketPerOver++;
//                    teamWickets++;
//                    batsman.setRuns(runsPerBatsman);
//                    runsPerBatsman = 0;
//                    if(currBatsman==B.getBatsmen().size()){
//                        currBowlerAsBatsman++;
//                    }
//                    else{
//                        currBatsman++;
//                    }
//                    if(validBatsman(currBatsman)){
//                        batsman = B.getBatsmen().get(currBatsman);
//                    }
//                    else if(validBowlerAsBatsman(currBowlerAsBatsman)){
//                        batsman = B.getBowlers().get(currBowlerAsBatsman);
//                    }
//                }
//                else{
//                    int runPerBall = batsman.run();
//                    runsPerBatsman = runsPerBatsman+runPerBall;
//                    teamRuns = teamRuns+runPerBall;
//                }
//            }
//            bowler.setWickets(bowler.getWickets()+wicketPerOver);
//            wicketPerOver = 0;
//            ballsPerOver = 0;
//            prevBowler = currBowler;
//
//        } while (teamWickets!=totalMembers && totalBalls!=B.getOvers()*6);
//        batsman.setRuns(runsPerBatsman);
//        B.setRuns(teamRuns);
//        B.setWicket(teamWickets);
//        setSecondInnings();
//    }
}
