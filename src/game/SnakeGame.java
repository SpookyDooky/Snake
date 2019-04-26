package game;

import game.gamelogic.GameController;
import game.gamelogic.State;
import game.menus.MainMenu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeGame extends Application {

    private static SnakeGame gameInstance;
    private GameController game;

    private Stage mainStage;
    private Scene mainScene;

    private MainMenu mainMenu;

    private Highscores highscores;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        gameInstance = this;
        this.mainStage = primaryStage;
        primaryStage.setTitle("Snake");

        this.mainScene = new Scene(new Pane(),1000,1000);

        this.mainMenu = new MainMenu(new Pane());
        primaryStage.setScene(this.mainMenu);

        primaryStage.show();
        primaryStage.toFront();

        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Shutting down game...");
            Platform.exit();
            System.exit(1);
        });

        this.game = new GameController();
        this.game.setGameState(State.InMenus);
    }

    public static SnakeGame getGameInstance(){
        return gameInstance;
    }

    public Stage getMainStage(){
        return this.mainStage;
    }

    public GameController getGame(){
        return this.game;
    }

    public void resetGame(){
        this.game = new GameController();
        this.game.setGameState(State.InMenus);
    }

    public void launchGame(String mapName){
        resetGame();
        if(game.getGameState() != State.InMenus){
            System.out.println("Something went wrong");
        } else {
            this.game.setMap(mapName);
            this.game.setGameState(State.InitializingGame);
            try {
                this.game.startGame();
            } catch (IOException e) {
                System.out.println("Couldn't find a map with that name!");
                e.printStackTrace();
            }
        }
    }

    public void initHighscores(){
        this.highscores = new Highscores();
        this.highscores.init();
    }

    public Highscores getHighscores(){
        return this.highscores;
    }
}
