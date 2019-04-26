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
        Text highscoreText = new Text();
        Highscores currentScores = SnakeGame.getGameInstance().getHighscores();

        ArrayList<HighscoreEntry> entries = currentScores.getEntries();
        String highscoreString = "";

        int amount = 10;
        int fillerBuff = 0;
        if(entries.size() < 10){
            amount = entries.size();
            fillerBuff = 10 - amount;
        }

        for(int x = 1; x <= amount;x++){
            HighscoreEntry currentEntry = entries.get(x-1);
            String entryString = String.valueOf(x) + ". " + currentEntry.getName() + " " + currentEntry.getScore() + "\n";
            highscoreString += entryString;
        }

        for(int x = 1; x <= fillerBuff;x++){
            int spot = amount + x;
            String entry = String.valueOf(spot) + "\n";
            highscoreString += entry;
        }

        highscoreText.setText(highscoreString);
        highscoreText.setWrappingWidth(800);
        highscoreText.setTextAlignment(TextAlignment.CENTER);
        highscoreText.setFont(this.getMenuFont());

        highscoreText.setLayoutY(150);
        this.getRootPane().getChildren().add(highscoreText);
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
