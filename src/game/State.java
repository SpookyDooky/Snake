package game;

public enum State {

    GameOver("Game over!",false),
    Playing("Playing...",true),
    Paused("Game is paused",false),
    InMenus("Browsing the menus",false),
    InitializingGame("Setting up the environment",false),
    BeatTheGame("You beat the level",false),
    NextLevel("Moving to the next level",false),
    Unknown("Unknown", false);

    private String message;
    private boolean canMove;

    State(String message,boolean canMove){
        this.message = message;
        this.canMove = canMove;
    }

    String getMessage(){
        return this.getMessage();
    }

    boolean canMove(){
        return this.canMove;
    }
}
