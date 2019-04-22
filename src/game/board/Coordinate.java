package game.board;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean equals(Object other){
        if(other instanceof Coordinate){
            Coordinate otherC = (Coordinate) other;
            return otherC.x == this.x && otherC.y == this.y;
        }
        return false;
    }
}
