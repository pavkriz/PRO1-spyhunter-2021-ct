package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class NonRoadTile extends AbstractTile {

    public NonRoadTile(Image image) {
        super(image);
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
