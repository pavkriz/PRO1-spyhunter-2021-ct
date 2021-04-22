package cz.uhk.pro1.spyhunter.model;

import java.awt.*;
import java.awt.font.GraphicAttribute;

public class Game {
    Tile [][] map = new Tile[20][10];
    int elapsedY = 0;
    boolean gameOver = false;
    public Car car = new Car(150,150);
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
    public void setTileOnMap(int i,int j, Tile tile) {
        map[i][j]=tile;
    }
    public Tile[][] getMap()
    {
        return map;
    }


    public void drawMap(Graphics g) {
        int shiftMap = 300;
        int numberOfLinesToDraw = shiftMap/Tile.SIZE +2; // TODO proc +2 ?
        for (int i = elapsedY/Tile.SIZE; i < elapsedY/Tile.SIZE + numberOfLinesToDraw; ++i) {
            for (int j = 0; j < getSloupce(); ++j) {
                // - i*Tile.SIZE dalsi a dalsi dlazdice, minus = kresli vice a vice nahoru
                // + elapsedY posune vykresleni mapy o elapsedY pixelu, plus = dolu (nize) "ubiha dolu v case"
                // + shiftMap posune vykresleni mapy smerem dolu o velikost okna (jinak by byla cela nareslena "nahoru" mimo okno do zapornych souradnic)

                int x = j*Tile.SIZE;
                int y = - i*Tile.SIZE + elapsedY + shiftMap;
                Tile tile = map[i % getRadky()][j];
                tile.drawTile(g, x,  y);



                if(car.collidesWithTile(x,y))
                {
                    tile.actionOnCollision(this);
                }
            }
        }
        car.draw(g);
    }

    public void moveCar(int dx){
        if (!gameOver) {
            car.moveCar(dx);
        }
    }

    /**
     * Metoda je zavolana automaticky kazdych x milisekund.
     * Aktualizuje herni stav: posune mapu, pohne autem, detekuje kolize auta s hernimi predmety v mape
     */
    public void tickGame() {
        if (!gameOver) {
            elapsedY += 1;
        }
    }
}
