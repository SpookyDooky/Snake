package game.unit.movingunits;

import game.Direction;
import game.SnakeGame;
import game.board.Tile;
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
        Direction nextUnitDir = this.nextChainLink.getDirection();
        if(nextUnitDir != this.getDirection()){
            moveTile();
            this.setDirection(nextUnitDir);
        } else {
            moveTile();
        }
    }

    private void moveTile(){
        Tile current = SnakeGame.getGameInstance().getGame().getGameBoard().tileAt(this.getX(),this.getY());
        Tile next  = current.tileAt(this.getDirection());

        this.setX(this.getX() + this.getDirection().getDeltX());
        this.setY(this.getY() + this.getDirection().getDeltY());

        current.getOccupants().remove(this);
        next.getOccupants().add(this);
    }
}
