package com.tekion;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> batsmen;
    private List<Player> bowlers;

    private List<Player> players;
    private int wicket;
    private int runs;
    private int overs;

    public Team(String name, int overs){
        this.name = name;
        this.overs = overs;
    }

    public void setBatsmen(List<Player> batsmen){
        this.batsmen = batsmen;
    }
    public List<Player> getBatsmen() {
        return batsmen;
    }
    public void setBowlers(List<Player> bowlers){
        this.bowlers = bowlers;
    }
    public List<Player> getBowlers() {
        return bowlers;
    }

    public int getRuns(){
        return runs;
    }
    public int getWicket(){
        return wicket;
    }
    public String getName(){
        return name;
    }

    public int getOvers(){
        return overs;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}




//public class Team {
//
//    private String name;
//    private int wicket;
//    private int runs;
//    private int overs;
//
//    public Team(String name, int overs){
//        this.name = name;
//        this.overs = overs;
//    }
//
//    public int getRuns(){
//        return runs;
//    }
//    public int getWicket(){
//        return wicket;
//    }
//    public String getName(){
//        return name;
//    }
//
//    public int getOvers(){
//        return overs;
//    }
//
//    public int batting(){
//        int balls=0;
//        do{
//            balls++;
//            int val = (int)(Math.random()*8);
//            if(val==7){
//                wicket++;
//            }
//            else{
//                runs = runs+val;
//            }
//        }while(wicket!=10 && balls!=overs*6);
//        return runs;
//    }
//}
