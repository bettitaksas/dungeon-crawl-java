package com.codecool.dungeoncrawl.data.items;

public class Key extends Item {
    public Key(int amount) {
        super(amount);
    }

    @Override
    public String getTileName() {
        return "goldKey";
    }
}
