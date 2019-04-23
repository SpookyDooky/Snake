package game.board;

import game.Direction;
import game.unit.MovingUnit;
import game.unit.ScoreUnit;
import game.unit.Unit;
import game.unit.movingunits.SnakeHead;

import java.io.*;
import java.util.ArrayList;

public class GameBoard {

    private int width;
    private int height;

    private Coordinate spawnpoint;

    private Tile[][] tileGrid;
    private char[][] charGrid;

    private String mapName;

    /**
     * Basic constructor
     * @param mapName
     */
    public GameBoard(String mapName){
        this.tileGrid = new Tile[width][height];
        this.mapName = mapName;
        init();
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    /**
     * Method for initializing everything
     */
    public void init(){
        initGame();
        initTiles();
        linkTiles();
        linkAroundTiles();
        linkCornersAround();
        spawnRandomDot();
    }

    /**
     * Reads out the file, begin of map initialization
     */
    private void initGame(){
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File("src\\maps\\" + this.mapName)));
            String dimensions = reader.readLine();
            String[] splitted = dimensions.split(" ");

            this.width = Integer.valueOf(splitted[0]);
            this.height = Integer.valueOf(splitted[1]);
            this.charGrid = new char[this.width][this.height];
            this.tileGrid = new Tile[width][height];

            for(int y = 0; y < this.height;y++){
                String line = reader.readLine();
                char[] charArray = line.toCharArray();
                for(int x = 0; x < this.width;x++){
                    charGrid[x][y] = charArray[x];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes all the tiles
     */
    private void initTiles(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                switch(charGrid[x][y]){
                    case '#': tileGrid[x][y] = new Tile(true, new Coordinate(x,y));
                    break;
                    case 'H': {
                        this.spawnpoint = new Coordinate(x,y);
                        MovingUnit snake = new SnakeHead(x,y);
                        Tile current = new Tile(false,this.spawnpoint);
                        current.getOccupants().add(snake);
                        tileGrid[x][y] = current;
                    } break;
                    case 'O': tileGrid[x][y] = new Tile(false,new Coordinate(x,y));
                    break;

                }
            }
        }
    }

    /**
     * Link loop
     */
    private void linkTiles(){
        for(int x = 0; x < width;x++){
            for(int y = 0; y < height; y++){
                linkTile(tileAt(x,y));
            }
        }
    }

    /**
     * For linking regular tiles
     * @param current - The tile we want to link to its neighbours
     */
    private void linkTile(Tile current){
        for(Direction direction : Direction.values()){
            Coordinate currentCoordinate = current.getCoordinate();
            int newX = currentCoordinate.getX() + direction.getDeltX();
            int newY = currentCoordinate.getY() + direction.getDeltY();

            if(newX >= 0 && newX < this.width && newY >= 0 && newY < this.height){
                current.getMoveMap().put(direction,tileAt(newX,newY));
            }
        }
    }

    /**
     * For making the map go around, this is for future game features
     */
    private void linkAroundTiles(){
        for(int x = 1; x < this.width - 1;x++){
            tileAt(x,0).getMoveMap().put(Direction.North,tileAt(x,this.height - 1));
            tileAt(x,this.height-1).getMoveMap().put(Direction.South,tileAt(x,0));
        }

        for(int y = 1; y < this.height -1;y++){
            tileAt(0,y).getMoveMap().put(Direction.West,tileAt(this.width-1,y));
            tileAt(this.width-1,y).getMoveMap().put(Direction.East,tileAt(0,y));
        }
    }

    /**
     * For making the corners go around
     */
    private void linkCornersAround(){
        tileAt(0,0).getMoveMap().put(Direction.West,tileAt(this.width -1,0));
        tileAt(0,0).getMoveMap().put(Direction.North,tileAt(0,this.height-1));

        tileAt(this.width-1,0).getMoveMap().put(Direction.East,tileAt(0,0));
        tileAt(this.width-1,0).getMoveMap().put(Direction.North,tileAt(this.width-1,this.height-1));

        tileAt(0,this.height-1).getMoveMap().put(Direction.West,tileAt(this.width -1,this.height - 1));
        tileAt(0,this.height-1).getMoveMap().put(Direction.North,tileAt(0,0));

        tileAt(this.width-1, this.height-1).getMoveMap().put(Direction.East,tileAt(0,this.height-1));
        tileAt(this.width-1, this.height-1).getMoveMap().put(Direction.North,tileAt(this.width - 1,0));
    }

    /**
     * Returns a tile
     * @param x - The x value
     * @param y - The y value
     * @return - The tile at that location
     */
    public Tile tileAt(int x, int y){
        return tileGrid[x][y];
    }

    /**
     * Finds a unit on the board
     * @param unit - The class of the unit
     * @return - All units that belong to that class
     */
    public ArrayList<Unit> findUnit(Class unit){
        Tile[][] theGridClone = this.tileGrid.clone();
        ArrayList<Unit> result = new ArrayList<>();
        for(int x = 0; x < this.width;x++){
            for(int y = 0; y < this.height;y++){
                ArrayList<Unit> cloned = theGridClone[x][y].getOccupants();

                for(Unit occupant : cloned){
                    if(unit.isInstance(occupant)){
                        result.add(occupant);
                    }
                }
            }
        }
        return result;
    }

    /**
     * @return - Returns the tile grid
     */
    public Tile[][] getTileGrid(){
        return this.tileGrid;
    }

    public void spawnRandomDot(){
        int randomX = (int) (Math.random() * this.width);
        int randomY = (int) (Math.random() * this.height);

        Tile target = tileAt(randomX,randomY);
        if(!target.isBorder()){
            target.getOccupants().add(new ScoreUnit(randomX,randomY,1));
        } else {
            spawnRandomDot();
        }
    }
}
