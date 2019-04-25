package game.menus;

import game.SnakeGame;
import game.State;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GameOver extends MenuScene {

    public GameOver(Pane root) {
        super(root);
        setupMainButton();
        setupGameOverText();
        setupScoreText();
    }


    private void setupGameOverText(){
        Text gameOver = new Text();
        gameOver.setText("GAME OVER!");

        gameOver.setFont(new Font("arial BOLD",40));

        gameOver.setWrappingWidth(800);
        gameOver.setTextAlignment(TextAlignment.CENTER);
        gameOver.setLayoutY(75);
        this.getRootPane().getChildren().add(gameOver);
    }

    private void setupScoreText(){
        Text scoreText = new Text();
        scoreText.setText("Achieved score: " + String.valueOf(SnakeGame.getGameInstance().getGame().getScore()));

        scoreText.setFont(this.getDefaultFont());
        scoreText.setWrappingWidth(800);
        scoreText.setTextAlignment(TextAlignment.CENTER);
        scoreText.setLayoutY(150);

        this.getRootPane().getChildren().add(scoreText);
    }

    private void setupMainButton(){
        Button returnButton = new Button();
        returnButton.setText("Main Menu");
        returnButton.setMinHeight(50);
        returnButton.setMaxHeight(50);
        returnButton.setMinWidth(300);
        returnButton.setMaxWidth(300);
        returnButton.setLayoutX(250);
        returnButton.setLayoutY(675);

        returnButton.setFont(this.getMenuFont());
        
        returnButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
            SnakeGame.getGameInstance().getGame().setGameState(State.InMenus);
        });
        this.getRootPane().getChildren().add(returnButton);
    }

}
