package game.menus;

import game.HighscoreEntry;
import game.Highscores;
import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class HighscoreMenu extends MenuScene{

    public HighscoreMenu(Pane root) {
        super(root);
        setupTitle();
        setupBackButton();
        setupScores();
    }

    private void setupTitle(){
        Text title = new Text();
        title.setText("Highscores");

        title.setWrappingWidth(800);
        title.setTextAlignment(TextAlignment.CENTER);

        title.setFont(new Font("arial BOLD", 40));
        title.setLayoutY(75);

        this.getRootPane().getChildren().add(title);
    }

    private void setupScores(){
        Text highscoreRank = new Text();
        Text highscoreName = new Text();
        Text highscoreScore = new Text();

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

        highscoreRank.setLayoutY(150);
        highscoreName.setLayoutY(150);
        highscoreScore.setLayoutY(150);

        highscoreName.setLayoutX(250);
        highscoreScore.setLayoutX(550);

        this.getRootPane().getChildren().add(highscoreRank);
        this.getRootPane().getChildren().add(highscoreName);
        this.getRootPane().getChildren().add(highscoreScore);
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

        backButton.setFont(this.getMenuFont());
        backButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
        });

        this.getRootPane().getChildren().add(backButton);
    }

}
