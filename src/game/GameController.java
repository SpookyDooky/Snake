package game;

import game.board.GameBoard;
import game.unit.MovingUnit;
import game.unit.Unit;
import game.unit.movingunits.SnakeHead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GameController extends Timer {

    private String mapName;

    private State gameState;
    private GameBoard gameBoard;
    private GameScreen screen;
    private int score;

    public GameController(){
        super(200,null);
        this.setRepeats(true);
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
        System.out.println("Score: " + this.score);
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

        ArrayList<Unit> unitList = this.gameBoard.findUnit(SnakeHead.class);
        initSnake(unitList);

        //Starts loop
        initTimer();
        SnakeGame.getGameInstance().getGame().setGameState(State.Playing);
        this.start();
    }

    private void initSnake(ArrayList<Unit> unitList){
        for(Unit unit : unitList){
            if(unit instanceof SnakeHead){
                ((SnakeHead) unit).initSnakeStart();
            }
        }
    }

    private void initTimer(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profiler.getInstance().begin();
                //System.out.println("Game Tick");
                screen.repaint();
                ArrayList<Unit> movingUnits = SnakeGame.getGameInstance().getGame().getGameBoard().findUnit(MovingUnit.class);
                //System.out.println(movingUnits.size());
                updateTiles(movingUnits);
                moveUnits(movingUnits);
                Profiler.getInstance().end();
            }
        });

    }

    private void updateTiles(ArrayList<Unit> unitList){
        for(Unit unit : unitList){
            if(unit instanceof MovingUnit){
                ((MovingUnit) unit).updateLastTile();
            }
        }
    }

    private void moveUnits(ArrayList<Unit> unitList){
        for(Unit unit : unitList){
            if(unit instanceof MovingUnit){
                //System.out.println(((MovingUnit) unit).getX());
                ((MovingUnit) unit).moveUnit();
            }
        }
    }
}
