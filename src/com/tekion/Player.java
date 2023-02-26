package com.tekion;

public abstract class Player {
    private String name;
    private int runs;
    private int wickets;

    public abstract int run();
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getRuns() {
        return runs;
    }
    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wicket) {
        this.wickets = wicket;
    }
}
/*
Kushal 10,2
        12
 */