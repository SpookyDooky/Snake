package game;

import game.board.Tile;
import game.unit.MovingUnit;
import game.unit.ScoreUnit;
import game.unit.Unit;

import javax.swing.*;
import java.awt.*;
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

        // center frame on primary monitor (todo: choose monitor option?)
        setLocationRelativeTo(null);

        this.setVisible(true);
        init();
    }

    public void init(){
        GameScreen test = this;
        this.addKeyListener(new GameKeyListener());

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
                //TODO - Move part of the code to permanent storage so that it wont need to be recalculated every time
                super.paintComponent(g);
                //System.out.println("drawing");
                Tile[][] gameField =  SnakeGame.getGameInstance().getGame().getGameBoard().getTileGrid();
                int gameWidth = SnakeGame.getGameInstance().getGame().getGameBoard().getWidth();
                int gameHeight = SnakeGame.getGameInstance().getGame().getGameBoard().getHeight();

                int windowWidth = this.getWidth();
                int windowHeight = this.getHeight();

                int blockWidth = windowWidth/gameWidth;
                int blockHeight = windowHeight/gameHeight;


                for(int x = 0; x < gameWidth;x++){
                    for(int y = 0; y < gameHeight;y++){
                        Tile current = gameField[x][y];
                        ArrayList<Unit> occupants = current.getOccupants();

                        g.setColor(Color.WHITE);
                        if(current.isBorder()){
                            g.setColor(Color.BLACK);
                        } else if(occupants.size() > 0){
                            for(int z = 0; z < occupants.size();z++){
                                Unit occupant = occupants.get(z);
                                if(occupant instanceof MovingUnit){
                                    g.setColor(Color.RED);
                                } else if(occupant instanceof ScoreUnit){
                                    g.setColor(Color.BLACK);
                                }
                            }
                        }

                        //g.drawRect(blockWidth * x,blockHeight*y,blockWidth,blockHeight);
                        g.fillRect(blockWidth * x,blockHeight * y,blockWidth,blockHeight);
                    }
                }
                g.setColor(Color.RED);
                g.drawString(Profiler.getInstance().toString(), 20, 20); // TODO unhardcode position
            }
        });
    }
}
