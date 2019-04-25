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

    public SnakeHead(int x, int y){
        super(x,y,Direction.South);
        this.length = 3;
    }

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

    private void addNewBlock(){
        //TODO - Might need logic in the future that prevents a sudden block in front of the head in certain cases, testing will be needed for this.
        Tile lastTileEnd = this.snakeEnd.getLastTile();
        Coordinate last = lastTileEnd.getCoordinate();
        SnakeBody newEnd = new SnakeBody(last.getX(),last.getY(),Direction.South,this.snakeEnd);
        this.snakeEnd = newEnd;
        lastTileEnd.getOccupants().add(newEnd);
    }

    public MovingUnit getSnakeEnd(){
        return this.snakeEnd;
    }

    public SnakeBody getFirstSnakePart(){
        return this.firstSnakePart;
    }

}
