package com.codecool.dungeoncrawl.data.items;

public class Egg extends Item{
    public Egg(int amount) {super(amount);}

    @Override
    public String getTileName() {
        return "egg";
    }
}
