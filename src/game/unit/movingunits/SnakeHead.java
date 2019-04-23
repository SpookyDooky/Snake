package game.unit.movingunits;

import game.Direction;
import game.SnakeGame;
import game.unit.MovingUnit;
import game.unit.Unit;

public class SnakeHead extends MovingUnit {

    private int length;

    public SnakeHead(int x, int y){
        super(x,y,Direction.South);
        this.length = 3;
    }

    public void increaseLength(){
        this.length++;
    }

    /*
     * Temporary snake spawn algorithm, in the future I want the orignal way of snake spawning, that it comes out of a hole in the ground.
     */
    public void initSnakeStart(){
        MovingUnit next = this;
        for(int x = 1; x <= this.length;x++){
            int newY = this.getY() - x;
            MovingUnit newNext = new SnakeBody(this.getX(),newY,this.getDirection(),next);
            SnakeGame.getGameInstance().getGame().getGameBoard().tileAt(this.getX(),newY).getOccupants().add(newNext);
            next = newNext;
        }
    }

}
