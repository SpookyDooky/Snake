package game.unit;

import game.Direction;
import game.SnakeGame;
import game.State;
import game.board.GameBoard;
import game.board.Tile;
import game.menus.GameOver;
import game.unit.movingunits.SnakeBody;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class MovingUnit extends Unit{

    private Direction direction;

    public MovingUnit(int x, int y, Direction direction){
        super(x,y);
        this.direction = direction;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public void moveUnit(){
        GameBoard board = SnakeGame.getGameInstance().getGame().getGameBoard();
        Tile current = board.tileAt(this.getX(),this.getY());
        Tile next = current.tileAt(this.direction);

        if(collision(next)) {
            current.getOccupants().remove(this);
            next.getOccupants().add(this);
            checkScoreUnit(next);
            this.setX(this.getX() + this.direction.getDeltX());
            this.setY(this.getY() + this.direction.getDeltY());
        } else {
            SnakeGame.getGameInstance().getGame().setGameState(State.GameOver);
            SnakeGame.getGameInstance().getGame().getScreen().dispose();
            SnakeGame.getGameInstance().getGame().stop();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    SnakeGame.getGameInstance().getMainStage().setScene(new GameOver(new Pane()));
                }
            });
        }
    }

    private boolean collision(Tile next){
        return !next.isBorder() && !containsMovingUnit(next);
    }

    private boolean containsMovingUnit(Tile next){
        ArrayList<Unit> unitList = next.getOccupants();
        for(Unit unit : unitList){
            if(unit instanceof SnakeBody){
                SnakeBody body = (SnakeBody) unit;
                if(body.getNextChainLink() != this){
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkScoreUnit(Tile next){
        ArrayList<Unit> unitList = next.getOccupants();
        for(Unit unit : unitList){
            if(unit instanceof ScoreUnit){
                ((ScoreUnit) unit).collide();
                SnakeGame.getGameInstance().getGame().getGameBoard().spawnRandomDot();
            }
        }
    }
}
