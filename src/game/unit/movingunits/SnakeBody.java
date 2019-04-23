package game.unit.movingunits;

import game.Direction;
import game.unit.MovingUnit;

public class SnakeBody extends MovingUnit {

    private MovingUnit nextChainLink;

    public SnakeBody(int x, int y, Direction direction, MovingUnit next){
        super(x,y,direction);
        this.nextChainLink = next;
    }

    /**
     * Updates the current direction, to the one in front of this body part, so that it becomes a train like moving unit.
     */
    public void updateDirection(){
        if(this.nextChainLink.getDirection() != this.getDirection()){
            this.setDirection(this.nextChainLink.getDirection());
        }
    }

    public MovingUnit getNextChainLink(){
        return this.nextChainLink;
    }

    @Override
    public void moveUnit() {
        super.moveUnit();
    }
}
