package game.menus;

import game.SnakeGame;
import game.State;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class GameOver extends MenuScene {

    public GameOver(Pane root) {
        super(root);
        setupMainButton();
    }

    private void setupMainButton(){
        Button returnButton = new Button();
        returnButton.setText("Main Menu");
        returnButton.setMinHeight(50);
        returnButton.setMaxHeight(50);
        returnButton.setMinWidth(300);
        returnButton.setMaxWidth(300);
        returnButton.setLayoutX(250);
        returnButton.setLayoutY(75);

        returnButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
            SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
        });
        this.getRootPane().getChildren().add(returnButton);
    }

}
