package game;

import game.unit.MovingUnit;
import game.unit.Unit;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int extended = e.getExtendedKeyCode();
        ArrayList<Unit> unit = SnakeGame.getGameInstance().getGame().getGameBoard().findUnit(MovingUnit.class);
        
        if(extended == KeyEvent.VK_W){

        } else if(extended == KeyEvent.VK_D){

        } else if(extended == KeyEvent.VK_S){

        } else if(extended == KeyEvent.VK_A){

        } else if(extended == KeyEvent.VK_ESCAPE){
            GameScreen theScreen = SnakeGame.getGameInstance().getGame().getScreen();
            theScreen.dispose();
            SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
        } else if(extended == KeyEvent.VK_P){
            //TODO - Change state to paused and make sure the game stops running
        }
    }
}
