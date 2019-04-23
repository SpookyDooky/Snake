package game;

import game.board.GameBoard;
import java.io.IOException;

public class GameController{

    private String mapName;

    private State gameState;
    private GameBoard gameBoard;
    private GameScreen screen;
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

    private void resetScore(){
        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public void incrementScore(){
        this.score++;
    }

    public GameBoard getGameBoard(){
        return this.gameBoard;
    }

    public void startGame() throws IOException {
        this.gameBoard = new GameBoard(this.mapName); //Loads up the map
        this.screen = new GameScreen(1000,1000);
        this.screen.repaint();
        resetScore(); //Resets the score
        start(); //Initiate tick speed and stuff, refresh rate should be 5, or equal to game speed, not really necessary to do more.
    }

    public void start(){
        //TODO - Run game logic
        //TODO - Render
    }
}
