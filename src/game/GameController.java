package game;

import game.board.GameBoard;

import javax.swing.*;
import java.io.IOException;

public class GameController extends Timer {

    private String mapName;

    private State gameState;
    private GameBoard gameBoard;
    private GameScreen screen;
    private int score;

    public GameController(){
        super(5,null);
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

    public GameScreen getScreen(){
        return this.screen;
    }

    public void startGame() throws IOException {
        this.gameBoard = new GameBoard(this.mapName); //Loads up the map
        this.screen = new GameScreen(1000,1000);
        this.screen.repaint();
        resetScore(); //Resets the score
    }
}
