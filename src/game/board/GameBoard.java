package game.board;

public class GameBoard {

    private int width;
    private int height;

    private Tile[][] tileGrid;

    public GameBoard(int width, int height){
        this.width = width;
        this.height = height;
        this.tileGrid = new Tile[width][height];
    }

    public void initBoard(){

    }
}
