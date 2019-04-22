package game.unit.movingunits;

import game.Direction;
import game.unit.MovingUnit;
import game.unit.Unit;

public class SnakeHead extends MovingUnit {

    private int length;

    public SnakeHead(int x, int y){
        super(x,y,Direction.South);
        this.length = 4;
    }

    public void increaseLength(){
        this.length++;
    }

}
