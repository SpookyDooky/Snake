package game;

import game.menus.MainMenu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    private Stage mainStage;
    private Scene mainScene;

    private MainMenu mainMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        primaryStage.setTitle("Snake");

        this.mainScene = new Scene(new Pane(),1000,1000);
        primaryStage.show();

        launchMenu();
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Shutting down game...");
            Platform.exit();
        });
    }

    private void launchMenu(){
        this.mainMenu = new MainMenu(new Pane());
        this.mainStage.setScene(this.mainMenu);
    }
}
