package game.unit;

import game.Direction;
import game.SnakeGame;
import game.board.GameBoard;
import game.board.Tile;

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
        Tile current =  board.tileAt(this.getX(),this.getY());

        Tile nextTile = current.tileAt(this.direction);
        current.getOccupants().remove(this);
        nextTile.getOccupants().add(this);
    }
}
