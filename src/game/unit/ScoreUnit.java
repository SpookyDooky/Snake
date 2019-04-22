package game.unit;

public class ScoreUnit extends Unit{

    private int score;

    public ScoreUnit(int x, int y, int score){
        super(x,y);
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }
}
