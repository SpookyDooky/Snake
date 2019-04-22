package game.board;

import game.Direction;
import game.unit.Unit;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {

    private ArrayList<Unit> occupants;
    private HashMap<Direction,Tile> moveMap;
    private boolean isBorder;
    private Coordinate coordinate;

    /**
     * Constructor for creating walls
     * @param isBorder - Boolean has to be true
     */
    public Tile(boolean isBorder,Coordinate coordinate){
        this.occupants = new ArrayList<>();
        this.moveMap = new HashMap<>();
        this.isBorder = isBorder;
        this.coordinate = coordinate;
    }

    public HashMap<Direction,Tile> getMoveMap(){
        return this.moveMap;
    }

    public ArrayList<Unit> getOccupants(){
        return this.occupants;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }
    /**
     * Method for making moving easier, so that we immediately know the next tile
     * @param direction - The direction that you want to know
     * @return - The square in that direction
     */
    public Tile tileAt(Direction direction){
        return moveMap.get(direction);
    }

    /**
     * Equals function, speaks for itself
     */
    public boolean equals(Object other){
        if(other instanceof Tile){
            Tile otherTile = (Tile) other;
            return this.coordinate.equals(otherTile.coordinate);
        } else {
            return false;
        }
    }
}
