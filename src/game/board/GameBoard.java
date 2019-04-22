package game.board;

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
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void initBoard(){
        for(int x = 0; x < this.width;x++){
            for(int y = 0; y < this.height;y++){

            }
        }
    }


}
