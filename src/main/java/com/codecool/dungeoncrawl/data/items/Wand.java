package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Wand extends Item{
    public Wand(int amount) {
        super(amount);
    }

    @Override
    public String getTileName() {
        return "wand";
    }
}
