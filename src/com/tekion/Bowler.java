package com.tekion;

public class Bowler extends Player {
    public Bowler(String name){
        setName(name);
    }
    @Override
    public int run() {
        return (int)(Math.random()*5);
    }


}
