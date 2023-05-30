package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Basiliscus;
import com.codecool.dungeoncrawl.data.actors.Octopus;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Dementor;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'd':
                            cell.setType(CellType.MONSTER);
                            new Dementor(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'X':
                            cell.setType(CellType.CLOSEDDOOR);
                            break;
                        case 'x':
                            cell.setType(CellType.OPENEDDOOR);
                            break;
                        case 'k':
                            cell.setType(CellType.GOLDKEY);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER);
                            break;
                        case 's':
                            cell.setType(CellType.SCUBA);
                            break;
                        case 'e':
                            cell.setType(CellType.EGG);
                            break;
                        case 'm':
                            cell.setType(CellType.WAND);
                            break;
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            new Octopus(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Basiliscus(cell);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
