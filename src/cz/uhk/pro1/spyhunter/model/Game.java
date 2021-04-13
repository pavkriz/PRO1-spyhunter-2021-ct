package cz.uhk.pro1.spyhunter.model;

import java.awt.*;
import java.awt.font.GraphicAttribute;

public class Game {
    Tile [][] map = new Tile[20][10];
    int elapsedY = 0;
    boolean gameOver = false;

    public boolean getGameOver()
    {
        return gameOver;
    }
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    public int getRadky()
    {
        return map.length;
    }
    public int getSloupce()
    {
        return map[0].length;
    }
    public void setTileOnMap(int i,int j, Tile tile)
    {
        map[i][j]=tile; }
    public Tile[][] getMap()
    {
        return map;
    }


    public void drawMap(Graphics g) {
        int shiftMap = 300;
        int numberOfLinesToDraw = shiftMap/Tile.SIZE + 2; // TODO proc +2 ?
        for (int i = elapsedY/Tile.SIZE; i < elapsedY/Tile.SIZE + numberOfLinesToDraw; ++i) {
            for (int j = 0; j < getSloupce(); ++j) {
                // - i*Tile.SIZE dalsi a dalsi dlazdice, minus = kresli vice a vice nahoru
                // + elapsedY posune vykresleni mapy o elapsedY pixelu, plus = dolu (nize) "ubiha dolu v case"
                // + shiftMap posune vykresleni mapy smerem dolu o velikost okna (jinak by byla cela nareslena "nahoru" mimo okno do zapornych souradnic)
                map[i % getRadky()][j].drawTile(g,j*Tile.SIZE,  - i*Tile.SIZE + elapsedY + shiftMap);
            }
        }
    }

    /*
    i  k
    0  0
    1  1
    2  2
    3  3
    4  4
    5  5
    6  6
    7  7
    8  8
    9  9
    10 10
    11 11
    12 12
    13 13
    14 14
    15 15
    16 16
    17 17
    18 18
    19 19
    20 0
    21 1
    22 2

     */

    /**
     * Metoda je zavolana automaticky kazdych x milisekund.
     * Aktualizuje herni stav: posune mapu, pohne autem, detekuje kolize auta s hernimi predmety v mape
     */
    public void tickGame() {
        elapsedY+=1;
    }
}
