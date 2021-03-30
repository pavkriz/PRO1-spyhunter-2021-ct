package cz.uhk.pro1.spyhunter.model;

public class NonRoadTile implements Tile {

    @Override
    public void drawTile() {
        // TODO
    }

    @Override
    public void actionOnCollision(Game game) {
        game.setGameOver(true);
    }

    @Override
    public String toString()
    {
        return "x";
    }
}
