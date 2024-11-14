package rocking_places;

import java.util.Random;

public class RockingMap {
    private Terrain[][] map;
    private int size;
    private Random random;

    public RockingMap(int size) {
        this.size = size;
        this.map = new Terrain[size][size];
        this.random = new Random();
        generateMap();
    }

    private void generateMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = getRandomTerrain();
            }
        }
    }

    private Terrain getRandomTerrain() {
        int pick = random.nextInt(Terrain.values().length);
        return Terrain.values()[pick];
    }

    public Terrain getTerrain(int x, int y) {
        return map[x][y];
    }

    public void displayMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j].toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public void displayMapWithPosition(int playerX, int playerY) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("* ");
                } else {
                    System.out.print(map[i][j].toString().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
