package game.board;

import game.Direction;
import game.unit.Unit;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {

    private ArrayList<Unit> occupants;
    private HashMap<Direction,Tile> moveMap;
    private boolean isBorder;
    private int x;
    private int y;

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

    public Tile(ArrayList<Unit> occupants, HashMap<Direction,Tile> moveMap, boolean isBorder, int x, int y){
        this.occupants = occupants;
        this.moveMap = moveMap;
        this.isBorder = isBorder;
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other){
        if(other instanceof Tile){
            Tile otherTile = (Tile) other;
            return this.x == otherTile.x && this.y == otherTile.y;
        } else {
            return false;
        }
    }
}
