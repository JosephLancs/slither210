package de.mat2095.my_slither;

import java.awt.Color;
import java.util.Random;

class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    private final Color colour;
    private static Random rand = new Random();

    private int r = rand.nextInt(255);
    private int g= rand.nextInt(255);
    private int b= rand.nextInt(255);


    Food(int x, int y, double size, boolean fastSpawn) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        spawnTime = System.currentTimeMillis();
        colour = new Color(r,g,b);
    }


    public Color getColour()
    {
        return colour;
    }

    double getSize() {
        return size;
    }

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }
}
