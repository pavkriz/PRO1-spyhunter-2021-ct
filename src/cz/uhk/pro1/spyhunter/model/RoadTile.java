package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class RoadTile extends AbstractTile {
    public RoadTile(Image image)
    {
       super(image);
    }


    @Override
    public void actionOnCollision(Game game) {
        //ok, nic se nedeje, kdyz "narazime" do policka "silnice"
    }

    @Override
    public String toString()
    {
        return " ";
    }
}
