package game.menus;

import game.HighscoreEntry;
import game.Highscores;
import game.SnakeGame;
import game.gamelogic.State;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class GameOver extends MenuScene {

    public GameOver(Pane root) {
        super(root);
        setupMainButton();
        setupGameOverText();
        setupScoreText();
        setupEnterName();
        setupInputField();
        setupSubmitButton();
        setupHeaders();
        setupScores();
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
        scoreText.setLayoutY(125);

        this.getRootPane().getChildren().add(scoreText);
    }

    private void setupEnterName(){
        Text enterName = new Text();
        enterName.setText("Enter name:");

        enterName.setFont(this.getDefaultFont());
        enterName.setWrappingWidth(250);
        enterName.setTextAlignment(TextAlignment.CENTER);

        enterName.setLayoutY(205);

        this.getRootPane().getChildren().add(enterName);
    }

    private void setupInputField(){
        TextField inputField = new TextField();

        inputField.setEditable(true);
        inputField.setFont(new Font("arial",25));

        inputField.setMinWidth(250);
        inputField.setMaxWidth(250);
        inputField.setMinHeight(50);
        inputField.setMaxHeight(50);

        inputField.setLayoutX(275);
        inputField.setLayoutY(175);

        this.getRootPane().getChildren().add(inputField);
    }

    private void setupSubmitButton(){
        Button submitButton = new Button();

        submitButton.setText("Submit");
        submitButton.setFont(this.getMenuFont());

        submitButton.setMinWidth(150);
        submitButton.setMaxWidth(150);
        submitButton.setMinHeight(50);
        submitButton.setMaxHeight(50);

        submitButton.setLayoutX(575);
        submitButton.setLayoutY(175);

        this.getRootPane().getChildren().add(submitButton);
    }

    private void setupHeaders(){
        Text header1 = new Text();
        Text header2 = new Text();
        Text header3 = new Text();

        header1.setText("Rank");
        header2.setText("Name");
        header3.setText("Score");

        header1.setWrappingWidth(250);
        header2.setWrappingWidth(300);
        header3.setWrappingWidth(250);

        header1.setTextAlignment(TextAlignment.CENTER);
        header2.setTextAlignment(TextAlignment.CENTER);
        header3.setTextAlignment(TextAlignment.CENTER);

        header1.setFont(this.getMenuFont());
        header2.setFont(this.getMenuFont());
        header3.setFont(this.getMenuFont());

        header1.setLayoutY(275);
        header2.setLayoutY(275);
        header3.setLayoutY(275);

        header2.setLayoutX(250);
        header3.setLayoutX(550);

        this.getRootPane().getChildren().add(header1);
        this.getRootPane().getChildren().add(header2);
        this.getRootPane().getChildren().add(header3);
    }

    private void setupScores(){
        Text highscoreRank = new Text();
        Text highscoreName = new Text();
        Text highscoreScore = new Text();

        SnakeGame.getGameInstance().initHighscores();
        Highscores currentScores = SnakeGame.getGameInstance().getHighscores();

        ArrayList<HighscoreEntry> entries = currentScores.getEntries();
        String rankString = "";
        String nameString = "";
        String scoreString = "";

        int amount = 10;
        int fillerBuff = 0;
        if(entries.size() < 10){
            amount = entries.size();
            fillerBuff = 10 - amount;
        }

        for(int x = 1; x <= amount;x++){
            HighscoreEntry currentEntry = entries.get(x-1);
            rankString += String.valueOf(x) + "\n";
            nameString += currentEntry.getName() + "\n";
            scoreString += String.valueOf(currentEntry.getScore()) + "\n";
        }

        for(int x = 1; x <= fillerBuff;x++){
            int spot = amount + x;
            rankString += String.valueOf(spot) + "\n";
        }

        highscoreRank.setText(rankString);
        highscoreName.setText(nameString);
        highscoreScore.setText(scoreString);

        highscoreRank.setWrappingWidth(250);
        highscoreName.setWrappingWidth(300);
        highscoreScore.setWrappingWidth(250);

        highscoreRank.setTextAlignment(TextAlignment.CENTER);
        highscoreName.setTextAlignment(TextAlignment.CENTER);
        highscoreScore.setTextAlignment(TextAlignment.CENTER);

        highscoreRank.setFont(this.getMenuFont());
        highscoreName.setFont(this.getMenuFont());
        highscoreScore.setFont(this.getMenuFont());

        highscoreRank.setLayoutY(300);
        highscoreName.setLayoutY(300);
        highscoreScore.setLayoutY(300);

        highscoreName.setLayoutX(250);
        highscoreScore.setLayoutX(550);

        this.getRootPane().getChildren().add(highscoreRank);
        this.getRootPane().getChildren().add(highscoreName);
        this.getRootPane().getChildren().add(highscoreScore);
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
