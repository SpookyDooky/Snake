package game;

import game.board.Tile;
import game.unit.MovingUnit;
import game.unit.ScoreUnit;
import game.unit.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameScreen extends JFrame {

    private int width;
    private int height;

    public GameScreen(int width, int height){
        this.width = width;
        this.height = height;
        this.setSize(width,height);
        this.setVisible(true);
        init();
    }

    public void init(){
        GameScreen test = this;
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE){
                    test.dispose();
                    SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                test.dispose();
                SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
            }
        });

        this.add(new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                //Needs to be brushed up for the correct scaling, this is only temporarily
                super.paintComponent(g);
                Tile[][] gameField =  SnakeGame.getGameInstance().getGame().getGameBoard().getTileGrid();
                int gameWidth = SnakeGame.getGameInstance().getGame().getGameBoard().getWidth();
                int gameHeight = SnakeGame.getGameInstance().getGame().getGameBoard().getHeight();

                int windowWidth = width;
                int windowHeight = height;

                int blockWidth = windowWidth/gameWidth;
                int blockHeight = gameHeight/windowHeight;

                for(int x = 0; x < gameWidth;x++){
                    for(int y = 0; y < gameHeight;y++){
                        Tile current = gameField[x][y];
                        ArrayList<Unit> occupants = current.getOccupants();
                        if(current.isBorder()){
                            g.setColor(Color.BLACK);
                        } else if(occupants.size() > 0){
                            for(int z = 0; z < occupants.size();z++){
                                Unit occupant = occupants.get(z);
                                if(occupant instanceof MovingUnit){
                                    g.setColor(Color.red);
                                } else if(occupant instanceof ScoreUnit){
                                    g.setColor(Color.BLACK);
                                } else {
                                    g.setColor(Color.WHITE);
                                }
                            }
                        }

                        g.fillRect(blockWidth * x,blockHeight * y,blockWidth,blockHeight);
                    }
                }
            }
        });
    }
}
