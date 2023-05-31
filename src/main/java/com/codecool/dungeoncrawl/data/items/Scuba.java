package com.codecool.dungeoncrawl.data.items;

public class Scuba extends Item{
    public Scuba(int amount) {
        super(amount);
    }
    @Override
    public String getTileName() {
        return "scuba";
    }
}
