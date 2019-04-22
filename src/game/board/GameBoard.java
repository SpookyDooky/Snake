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

            }
        }
    }

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

    public Tile tileAt(int x, int y){
        return tileGrid[x][y];
    }
}
