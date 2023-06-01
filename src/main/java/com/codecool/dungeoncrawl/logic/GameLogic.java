package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getWandAmount() { return Integer.toString(map.getPlayer().getWand()); }

    public String getKeyAmount() { return Integer.toString(map.getPlayer().getKey()); }

    public String getScubaAmount() { return Integer.toString(map.getPlayer().getScuba()); }

    public String getSocksAmount() { return Integer.toString(map.getPlayer().getSocks()); }


    public GameMap getMap() {
        return map;
    }

}