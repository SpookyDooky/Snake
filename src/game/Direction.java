package game;

public enum Direction {

    North(0,-1),
    East(1,0),
    South(0,1),
    West(-1,0);

    private final int deltX;
    private final int deltY;

    Direction(int deltX, int deltY){
        this.deltX = deltX;
        this.deltY = deltY;
    }

    public int getDeltX(){
        return this.deltX;
    }

    public int getDeltY(){
        return this.deltY;
    }
}
