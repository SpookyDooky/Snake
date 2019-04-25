package game;

public enum Direction {

    North(0,-1),
    East(1,0),
    South(0,1),
    West(-1,0);

    private final int deltX;
    private final int deltY;

    /**
     * Class for improving movement
     * @param deltX - Delta x
     * @param deltY - Delta y
     */
    Direction(int deltX, int deltY){
        this.deltX = deltX;
        this.deltY = deltY;
    }

    /**
     * Getter method for delta x
     * @return - Returns delta x
     */
    public int getDeltX(){
        return this.deltX;
    }

    /**
     * Getter method for delta y
     * @return - Returns delta y
     */
    public int getDeltY(){
        return this.deltY;
    }
}
