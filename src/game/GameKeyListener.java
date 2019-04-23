package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int extended = e.getExtendedKeyCode();
        if(extended == KeyEvent.VK_W){

        } else if(extended == KeyEvent.VK_D){

        } else if(extended == KeyEvent.VK_S){

        } else if(extended == KeyEvent.VK_A){
            
        }
    }
}
