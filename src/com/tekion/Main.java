package com.tekion;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static Team teamASetUp(){
        Team teamA = new Team("India",2);
        List<Player> teamABatsmen = new ArrayList<>();
        teamABatsmen.add(new Batsman("Dhoni"));
        teamABatsmen.add(new Batsman("Kohli"));
        teamA.setBatsmen(teamABatsmen);
        List<Player> teamABowlers = new ArrayList<>();
        teamABowlers.add(new Bowler("jadeja"));
        teamABowlers.add(new Bowler("Bumrah"));
        teamA.setBowlers(teamABowlers);
        return teamA;
    }
    public static Team teamBSetUp(){
        Team teamB = new Team("Australia",2);
        List<Player> teamBBatsman = new ArrayList<>();
        teamBBatsman.add(new Batsman("Warner"));
        teamBBatsman.add(new Batsman("Smith"));
        teamB.setBatsmen(teamBBatsman);
        List<Player> teamBBowlers = new ArrayList<>();
        teamBBowlers.add(new Bowler("Starc"));
        teamBBowlers.add(new Bowler("Lyon"));
        teamB.setBowlers(teamBBowlers);
        return teamB;
    }
    public static void startMatch(int toss, Match match, Team teamA, Team teamB){
        if(toss==0){
            System.out.println("Toss is won by "+teamA.getName());

            match.batting(teamA);
            System.out.println("Score of " +teamA.getName()+":"+teamA.getRuns()+" for "+teamA.getWicket());
            System.out.println(match.getFirstInnings());

            match.batting(teamB);
            System.out.println("Score of " +teamB.getName()+":"+teamB.getRuns()+" for "+teamB.getWicket());
            System.out.println(match.getSecondInnings());
        }
        else{
            System.out.println("Toss is won by "+ teamB.getName());

            match.batting(teamB);
            System.out.println("Score of " +teamB.getName()+":"+teamB.getRuns()+" for "+teamB.getWicket());
            System.out.println(match.getSecondInnings());

            match.batting(teamA);
            System.out.println("Score of " +teamA.getName()+":"+teamA.getRuns()+" for "+teamA.getWicket());
            System.out.println(match.getFirstInnings());
        }
    }
    public static void main(String[] args) {

        Team teamA = teamASetUp();
        Team teamB = teamBSetUp();

        Match match = new Match(teamA, teamB);

        Scanner sc = new Scanner(System.in);
        System.out.println("Yeah it's toss time!");
        System.out.println("Press 0 or 1:");
        int toss = sc.nextInt();

        startMatch(toss, match, teamA, teamB);
        match.result();
//        System.out.println();
//        System.out.println(teamA.getRuns());
//        System.out.println(teamA.getWicket());
//        System.out.println(teamA.getBatsmen().get(0).getName()+":"+teamA.getBatsmen().get(0).getRuns());
//        System.out.println(teamA.getBatsmen().get(1).getName()+":"+teamA.getBatsmen().get(1).getRuns());
//        System.out.println(teamA.getBowlers().get(0).getName()+":"+teamA.getBowlers().get(0).getRuns());
//        System.out.println(teamA.getBowlers().get(1).getName()+":"+teamA.getBowlers().get(1).getRuns());
//
//        System.out.println(teamB.getBowlers().get(0).getName()+":"+teamB.getBowlers().get(0).getWickets());
//        System.out.println(teamB.getBowlers().get(1).getName()+":"+teamB.getBowlers().get(1).getWickets());



//        Team teamA = new Team("India", 10);
//        Team teamB = new Team("Pakistan", 10);
//        int indiaRuns = teamA.batting();
//        int pakistanRuns = teamB.batting();
//        System.out.println("Runs of "+ teamA.getName()+":"+teamA.getRuns());
//        System.out.println("Runs of "+ teamB.getName()+":"+teamB.getRuns());
//        if(indiaRuns>pakistanRuns){
//            System.out.println("Winning team is "+teamA.getName());
//        }
//        else if(pakistanRuns>indiaRuns){
//            System.out.println("Winning team is "+teamB.getName());
//        }
//        else{
//            System.out.println("Match is drawn");
//        }
    }
}