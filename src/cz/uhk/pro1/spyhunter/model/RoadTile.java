package cz.uhk.pro1.spyhunter.model;

public class RoadTile implements Tile {
    @Override
    public void drawTile() {
        // TODO
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
