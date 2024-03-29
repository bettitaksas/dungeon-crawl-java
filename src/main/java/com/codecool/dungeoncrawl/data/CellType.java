package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    MONSTER("monster"),
    DEADENEMY("deadEnemy"),
    CLOSEDDOOR("closedDoor"),
    OPENEDDOOR("openedDoor"),
    GOLDKEY("goldKey"),
    WATER("water"),
    SCUBA("scuba"),
    SOCKS("socks"),
    WAND("wand");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}