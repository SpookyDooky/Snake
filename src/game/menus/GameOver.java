package game.menus;

import game.SnakeGame;
import game.State;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GameOver extends MenuScene {

    public GameOver(Pane root) {
        super(root);
        setupMainButton();
        setupScoreField();
    }

    private void setupScoreField(){
        TextField scoreField = new TextField();
        scoreField.setText("Score: " + String.valueOf(SnakeGame.getGameInstance().getGame().getScore()));
        scoreField.setMinHeight(50);
        scoreField.setMaxHeight(50);
        scoreField.setMinWidth(300);
        scoreField.setMaxWidth(300);
        scoreField.setLayoutX(250);
        scoreField.setLayoutY(75);

        scoreField.setEditable(false);
        this.getRootPane().getChildren().add(scoreField);
    }
    private void setupMainButton(){
        Button returnButton = new Button();
        returnButton.setText("Main Menu");
        returnButton.setMinHeight(50);
        returnButton.setMaxHeight(50);
        returnButton.setMinWidth(300);
        returnButton.setMaxWidth(300);
        returnButton.setLayoutX(250);
        returnButton.setLayoutY(200);

        returnButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
            SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
        });
        this.getRootPane().getChildren().add(returnButton);
    }

}
