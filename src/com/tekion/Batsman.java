package com.tekion;

public class Batsman extends Player {
    public Batsman(String name){
        setName(name);
    }
    @Override
    public int run() {
        return (int)(Math.random()*7);
    }

}
