package game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    }
}
