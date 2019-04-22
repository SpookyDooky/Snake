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
     * Used for initializing the field
     * @param coordinate - Coordinates of the tile
     */
    public Tile(Coordinate coordinate){
        this.occupants = new ArrayList<>();
        this.moveMap = new HashMap<>();
        this.isBorder = false;
        this.coordinate = coordinate;
    }

    /**
     * Constructor for creating walls
     * @param isBorder - Boolean has to be true
     */
    public Tile(boolean isBorder){
        if(!isBorder){
            throw new IllegalArgumentException("Can't use this constructor for non walls");
        }

        this.occupants = new ArrayList<>();
        this.moveMap = new HashMap<>();
        this.isBorder = true;
    }

    /**
     * Constructor for regular tiles
     * @param occupants - Occupants of that tile
     * @param moveMap - The map of the neighbours
     * @param isBorder - Checks if its a border
     * @param coordinate - Coordinate of the tile
     */
    public Tile(ArrayList<Unit> occupants, HashMap<Direction,Tile> moveMap, boolean isBorder, Coordinate coordinate){
        this.occupants = occupants;
        this.moveMap = moveMap;
        this.isBorder = isBorder;
        this.coordinate = coordinate;
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
