package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(29, 2));
        tileMap.put("dementor", new Tile(27, 6));
        tileMap.put("closedDoor", new Tile(10, 9));
        tileMap.put("openedDoor", new Tile(2, 9));
        tileMap.put("goldKey", new Tile(16, 23));
        tileMap.put("water", new Tile(8,5));
        tileMap.put("scuba", new Tile(28, 9));
        tileMap.put("egg", new Tile(18, 29));
        tileMap.put("wand", new Tile(0, 26));
        tileMap.put("octopus", new Tile(25,8));
        tileMap.put("basiliscus", new Tile(28,8));
        tileMap.put("deadEnemy", new Tile(0,14));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
