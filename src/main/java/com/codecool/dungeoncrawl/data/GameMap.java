package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Dementor;
import com.codecool.dungeoncrawl.data.actors.Player;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private Dementor dementor;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDementor(Dementor dementor) {
        this.dementor = dementor;
    }

    public Dementor getDementor() {
        return dementor;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}