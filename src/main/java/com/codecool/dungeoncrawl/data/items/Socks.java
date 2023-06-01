package com.codecool.dungeoncrawl.data.items;

public class Socks extends Item{
    public Socks(int amount) {super(amount);}

    @Override
    public String getTileName() {
        return "socks";
    }
}