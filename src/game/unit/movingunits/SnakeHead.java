package game.unit.movingunits;

import game.Direction;
import game.SnakeGame;
import game.board.Coordinate;
import game.board.Tile;
import game.unit.MovingUnit;

public class SnakeHead extends MovingUnit {

    private int length;
    private MovingUnit snakeEnd;

    private SnakeBody firstSnakePart;

    /**
     * Basic constructor
     * @param x - x value of the spawnlocation
     * @param y - y value of the spawnlocation
     */
    public SnakeHead(int x, int y){
        super(x,y,Direction.South);
        this.length = 3;
    }

    /**
     * For increasing the length of the snake
     */
    public void increaseLength(){
        this.length++;
        addNewBlock();
    }

    public void resetLength(){
        this.length = 3;
    }

    /*
     * Temporary snake spawn algorithm, in the future I want the orignal way of snake spawning, that it comes out of a hole in the ground.
     */
    public void initSnakeStart(){
        MovingUnit next = this;
        for(int x = 1; x <= this.length;x++){
            int newY = this.getY() - x;
            MovingUnit newNext = new SnakeBody(this.getX(),newY,this.getDirection(),next);

            if(x == 1){
                this.firstSnakePart = (SnakeBody)newNext;
            }

            SnakeGame.getGameInstance().getGame().getGameBoard().tileAt(this.getX(),newY).getOccupants().add(newNext);
            next = newNext;
        }
        this.snakeEnd = next;
    }

    /**
     * For actually adding the snakebody to the snake
     */
    private void addNewBlock(){
        Tile lastTileEnd = this.snakeEnd.getLastTile();
        Coordinate last = lastTileEnd.getCoordinate();
        SnakeBody newEnd = new SnakeBody(last.getX(),last.getY(),Direction.South,this.snakeEnd);
        this.snakeEnd = newEnd;
        lastTileEnd.getOccupants().add(newEnd);
    }

    /**
     * @return - Returns the tail of the snake
     */
    public MovingUnit getSnakeEnd(){
        return this.snakeEnd;
    }

    /**
     * Returns the very first piece after the snake head
     * @return - Returns a snakebody part
     */
    public SnakeBody getFirstSnakePart(){
        return this.firstSnakePart;
    }

}