package game.unit;

import game.SnakeGame;

public class ScoreUnit extends Unit{

    private int score;

    public ScoreUnit(int x, int y, int score){
        super(x,y);
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void collide(){
        SnakeGame.getGameInstance().getGame().getGameBoard().tileAt(this.getX(),this.getY()).getOccupants().remove(this);
    }
}
