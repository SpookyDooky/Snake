package game;

import game.unit.MovingUnit;
import game.unit.Unit;
import game.unit.movingunits.SnakeHead;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int extended = e.getExtendedKeyCode();
        ArrayList<Unit> unitList = SnakeGame.getGameInstance().getGame().getGameBoard().findUnit(MovingUnit.class);

        if(extended == KeyEvent.VK_W){
            changeDirection(Direction.North,unitList);
        } else if(extended == KeyEvent.VK_D){
            changeDirection(Direction.East,unitList);
        } else if(extended == KeyEvent.VK_S){
            changeDirection(Direction.South,unitList);
        } else if(extended == KeyEvent.VK_A){
            changeDirection(Direction.West,unitList);
        } else if(extended == KeyEvent.VK_ESCAPE){
            GameScreen theScreen = SnakeGame.getGameInstance().getGame().getScreen();
            theScreen.dispose();
            SnakeGame instance = SnakeGame.getGameInstance();
            instance.getGame().setGameState(State.InMenus);
            instance.getGame().stop();
        } else if(extended == KeyEvent.VK_P){
            //TODO - Change state to paused and make sure the game stops running
            SnakeGame.getGameInstance().getGame().setGameState(State.Paused);
        }
    }

    private void changeDirection(Direction direction, ArrayList<Unit> unitList){
        if(unitList.size() == 0){
            System.out.println("Unexpected empty list");
            return;
        }

        for (Unit current : unitList) {
            if (current instanceof SnakeHead) {
                ((SnakeHead) current).setDirection(direction);
            }
        }
    }
}
