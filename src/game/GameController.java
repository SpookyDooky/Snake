package game;

import game.board.GameBoard;

import java.io.File;
import java.io.IOException;

public class GameController {

    private String mapName;

    private State gameState;
    private GameBoard gameBoard;

    private int score;

    public GameController(){
        this.gameState = State.Unknown;
        this.score = 0;
    }

    public void setMap(String mapName){
        this.mapName = mapName;
    }

    public String getMapName(){
        return this.mapName;
    }

    public State getGameState(){
        return this.gameState;
    }

    public void setGameState(State gameState){
        this.gameState = gameState;
    }

    public void resetScore(){
        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public void incrementScore(){
        this.score++;
    }

    public void startGame() throws IOException {
        File check = new File("maps" + File.separator + mapName);

        this.gameBoard = new GameBoard(this.mapName);
        start();
    }

    public void start(){

    }
}
