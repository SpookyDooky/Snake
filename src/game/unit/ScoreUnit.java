package game.unit;

import game.SnakeGame;
import game.board.GameBoard;
import game.unit.movingunits.SnakeHead;

import java.util.ArrayList;

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
        SnakeGame game = SnakeGame.getGameInstance();
        game.getGame().getGameBoard().tileAt(this.getX(),this.getY()).getOccupants().remove(this);
        game.getGame().incrementScore();

        GameBoard board = SnakeGame.getGameInstance().getGame().getGameBoard();
        ArrayList<Unit> head = board.findUnit(SnakeHead.class);
        ((SnakeHead) head.get(0)).increaseLength();
    }
}
