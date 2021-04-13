package cz.uhk.pro1.spyhunter;

import cz.uhk.pro1.spyhunter.model.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    Game game = new Game();
    private final Timer timer = new Timer(20, actionEvent -> tick());
    GamePanel gamePanel = new GamePanel();

    class GamePanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            //System.out.println("paint");
            //super.paint(g);
            //g.fillRect(10, 20, 100, 200);
            game.drawMap(g);
        }
    }

    public MainWindow() {
        setTitle("SpyHunter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400,300));
        //p.setBackground(Color.RED);
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.setDoubleBuffered(true); // potencialne plynulejsi animace
        pack();
        populateGame();
        dumpGame();
        timer.start();
    }

    public void tick() {
        // aktualizovat novy herni stav
        game.tickGame();
        // prekreslit panel se hrou
        gamePanel.repaint();
        // kvuli lagovani v Linuxu: Synchronizes this toolkit's graphics state. Some window systems may do buffering
        // of graphics events. This method ensures that the display is up-to-date. It is useful for animation.
        Toolkit.getDefaultToolkit().sync();
    }

    private void populateGame() {
        NonRoadTile nonRoadTile = new NonRoadTile();
        RoadTile roadTile = new RoadTile();
        game = new Game();
        for(int i = 0; i <game.getRadky();++i)
        {
            for(int j = 0; j < game.getSloupce();++j)
            {
                if(j==0||j==game.getSloupce()-1)    // j = sloupec
                {
                    game.setTileOnMap(i,j,nonRoadTile);
                }
                else
                {
                    game.setTileOnMap(i,j,roadTile);
                }
            }
        }
        game.setTileOnMap(3,3, new PowerUpTile());
    }

    private void dumpGame() {
        Tile[][]map = game.getMap();

        for(int i = 0; i <game.getRadky();++i)
        {
            for(int j = 0; j < game.getSloupce();++j)
            {
                System.out.print(map[i][j].toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainWindow w = new MainWindow();
            w.setVisible(true);
            //MainWindow w2 = new MainWindow();
            //w2.setVisible(true);
        });
    }
}
