package cz.uhk.pro1.spyhunter.model;

public class Game {
    Tile [][] map = new Tile[20][10];
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
        map[i][j]=tile;
    }
    public Tile[][] getMap()
    {
        return map;
    }
}
