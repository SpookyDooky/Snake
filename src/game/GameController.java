package game;

public class GameController {

    private String mapName;

    private State gameState;

    public GameController(){
        this.gameState = State.Unknown;
    }

    public void setMap(String mapName){
        this.mapName = mapName;
    }

    public String getMap(){
        return this.mapName;
    }

    public State getGameState(){
        return this.gameState;
    }

    public void setGameState(State gameState){
        this.gameState = gameState;
    }

    public void startGame(){
        
    }
}
