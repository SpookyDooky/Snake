package game;

import game.board.GameBoard;
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

        SnakeGame instance = SnakeGame.getGameInstance();
        GameBoard board = instance.getGame().getGameBoard();
        ArrayList<Unit> snakeHead = board.findUnit(SnakeHead.class);
        SnakeHead head = (SnakeHead) snakeHead.get(0);
        //TODO - Add checks so you can't go from north to south
        if(extended == KeyEvent.VK_W){ //North
            changeDirection(Direction.North,unitList,head);
        } else if(extended == KeyEvent.VK_D){ //East
            changeDirection(Direction.East,unitList,head);
        } else if(extended == KeyEvent.VK_S){ //South
            changeDirection(Direction.South,unitList,head);
        } else if(extended == KeyEvent.VK_A){ //West
            changeDirection(Direction.West,unitList,head);
        } else if(extended == KeyEvent.VK_ESCAPE){ //Quit
            GameScreen theScreen = SnakeGame.getGameInstance().getGame().getScreen();

            theScreen.dispose();
            instance.getGame().setGameState(State.InMenus);
            instance.getGame().stop();
        } else if(extended == KeyEvent.VK_P){ //Pause
            GameController game = instance.getGame();

            if(game.getGameState() == State.Paused){
                game.setGameState(State.Playing);
                game.start();
            } else if(game.getGameState() == State.Playing){
                game.setGameState(State.Paused);
                game.stop();
            }
        }
    }

    private void changeDirection(Direction direction, ArrayList<Unit> unitList, SnakeHead head){
        if(SnakeGame.getGameInstance().getGame().getGameState() != State.Paused && notOpposite(direction,head)) {
            if (unitList.size() == 0) {
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

    private boolean notOpposite(Direction desired, SnakeHead head){
        Direction opposite = Direction.opposite(desired);
        return head.getDirection() != opposite;
    }
}
