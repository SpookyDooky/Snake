package game.gamelogic;

import game.Direction;
import game.SnakeGame;
import game.board.GameBoard;
import game.board.Tile;
import game.unit.Unit;
import game.unit.movingunits.SnakeHead;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameKeyListener extends KeyAdapter {

    /**
     * Method that takes care of key events
     * @param e - The key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int extended = e.getExtendedKeyCode();

        SnakeGame instance = SnakeGame.getGameInstance();
        GameBoard board = instance.getGame().getGameBoard();
        ArrayList<Unit> snakeHead = board.findUnit(SnakeHead.class);
        SnakeHead head = (SnakeHead) snakeHead.get(0);
        //TODO - Add checks so you can't go from north to south
        if(extended == KeyEvent.VK_W){ //North
            changeDirection(Direction.North,head);
        } else if(extended == KeyEvent.VK_D){ //East
            changeDirection(Direction.East,head);
        } else if(extended == KeyEvent.VK_S){ //South
            changeDirection(Direction.South,head);
        } else if(extended == KeyEvent.VK_A){ //West
            changeDirection(Direction.West,head);
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

    /**
     * Method that takes care of changing the direction
     * @param direction - The wanted direction
     * @param head - The head of the snake
     */
    private void changeDirection(Direction direction, SnakeHead head){
        if(SnakeGame.getGameInstance().getGame().getGameState() != State.Paused && notOpposite(direction,head) && antiUTurn(direction,head)) {
            head.setDirection(direction);
        }
    }

    /**
     * Method that makes sure the snake cant turn 180 degrees in one tick
     * @param desired - Wanted direction
     * @param head - Head of the snake
     * @return - Boolean indicating if the direction is allowable
     */
    private boolean notOpposite(Direction desired, SnakeHead head){
        Direction opposite = Direction.opposite(desired);
        return head.getDirection() != opposite;
    }

    private boolean antiUTurn(Direction direction, SnakeHead head){
        Tile current = SnakeGame.getGameInstance().getGame().getGameBoard().tileAt(head.getX(),head.getY());
        Tile desired = current.tileAt(direction);

        return !desired.getOccupants().contains(head.getFirstSnakePart());
    }
}