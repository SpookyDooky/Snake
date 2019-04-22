package game.menus;

import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MapSelection extends MenuScene {

    public MapSelection(Pane root){
        super(root);
        setupBackButton();
        //For now just one map
        //This system will need to be changed in the future.
        setupMapButton();
    }

    private void setupMapButton(){
        Button mapButton = new Button();
        mapButton.setText("standard");
        mapButton.setMinWidth(300);
        mapButton.setMaxWidth(300);
        mapButton.setMinHeight(50);
        mapButton.setMaxHeight(50);
        mapButton.setLayoutX(250);
        mapButton.setLayoutY(75);

        mapButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().launchGame("standardmap");
        });
        this.getRootPane().getChildren().add(mapButton);
    }

    private void setupBackButton(){
        Button backButton = new Button();
        backButton.setText("Back");
        backButton.setMinWidth(300);
        backButton.setMaxWidth(300);
        backButton.setMinHeight(50);
        backButton.setMinHeight(50);
        backButton.setLayoutX(250);
        backButton.setLayoutY(675);

        backButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
        });

        this.getRootPane().getChildren().add(backButton);
    }
}
