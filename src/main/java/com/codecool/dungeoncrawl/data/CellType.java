package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    CLOSEDDOOR("closedDoor"),
    OPENEDDOOR("openedDoor"),
    GOLDKEY("goldKey"),
    WATER("water"),
    SCUBA("scuba"),
    EGG("egg"),
    WAND("wand");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}