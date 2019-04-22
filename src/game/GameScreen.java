package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

            }
        });
    }
}
