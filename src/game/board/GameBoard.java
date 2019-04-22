package game.board;

import game.Direction;

public class GameBoard {

    private int width;
    private int height;

    private Coordinate spawnpoint;
    private Tile[][] tileGrid;

    public GameBoard(int width, int height, Coordinate spawnpoint){
        this.width = width;
        this.height = height;
        this.spawnpoint = spawnpoint;
        this.tileGrid = new Tile[width][height];
        init();
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void init(){
        initTiles();
        linkTiles();
        linkAroundTiles();
        linkCornersAround();
    }

    private void initTiles(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                tileGrid[x][y] = new Tile(new Coordinate(x,y));
            }
        }
    }

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

    public Tile tileAt(int x, int y){
        return tileGrid[x][y];
    }
}
