package cz.uhk.pro1.spyhunter.model;

import java.awt.*;
import java.awt.font.GraphicAttribute;

public class Game {
    Tile [][] map = new Tile[20][10];
    int elapsedY = 0;
    boolean gameOver = false;
    int score = 0;
    int windowHeight=0;
    int windowWidt=0;
    int tileSize=0;

    int normalTickShift = 1;

    private Car car;
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

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowWidt() {
        return windowWidt;
    }

    public void setWindowWidt(int windowWidt) {
        this.windowWidt = windowWidt;
    }

    public void drawMap(Graphics g) {
        int shiftMap = 800;
        int numberOfLinesToDraw = shiftMap/tileSize + 2; // TODO proc +2 ?
        for (int i = elapsedY/tileSize; i < elapsedY/tileSize + numberOfLinesToDraw; ++i) {
            for (int j = 0; j < getSloupce(); ++j) {
                // - i*tileSize dalsi a dalsi dlazdice, minus = kresli vice a vice nahoru
                // + elapsedY posune vykresleni mapy o elapsedY pixelu, plus = dolu (nize) "ubiha dolu v case"
                // + shiftMap posune vykresleni mapy smerem dolu o velikost okna (jinak by byla cela nareslena "nahoru" mimo okno do zapornych souradnic)

                int x = j*tileSize;
                int y = - i*tileSize + elapsedY + shiftMap;
                Tile tile = map[i % getRadky()][j];
                tile.drawTile(g, x,  y);



                if(car.collidesWithTile(x,y, tileSize))
                {
                    tile.actionOnCollision(this);
                }

                if (i == ((elapsedY/tileSize + numberOfLinesToDraw) - 1) && tile instanceof PowerUpTile) {
                    ((PowerUpTile)tile).reactivatePowerUp();
                }
            }
        }
        g.setColor(Color.white);
        g.drawString("Score: " + score, 5, 15);
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
            elapsedY += normalTickShift;
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getElapsedY() {
        return elapsedY;
    }

    public void setElapsedY(int elapsedY) {
        this.elapsedY = elapsedY;
    }


    public void setNormalTickShift(int normalTickShift) {
        this.normalTickShift = normalTickShift;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
