package game.menus;

import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenu extends MenuScene{

    public MainMenu(Pane rootpane){
        super(rootpane);
        setupPlayButton();
        setupHighscoreButton();
    }

    private void setupPlayButton(){
        Button playButton = new Button();
        playButton.setText("Play!");
        playButton.setMinHeight(50);
        playButton.setMaxHeight(50);
        playButton.setMinWidth(300);
        playButton.setMaxWidth(300);
        playButton.setLayoutX(250);
        playButton.setLayoutY(75);

        playButton.setOnMouseClicked(event -> {
            System.out.println("Routing to the map selection");
            SnakeGame.getGameInstance().getMainStage().setScene(new MapSelection(new Pane()));
        });
        this.getRootPane().getChildren().add(playButton);
    }

    private void setupHighscoreButton(){
        Button highscore = new Button();
        highscore.setText("Highscores");
        highscore.setMinHeight(50);
        highscore.setMaxHeight(50);
        highscore.setMinWidth(300);
        highscore.setMaxWidth(300);
        highscore.setLayoutX(250);
        highscore.setLayoutY(200);

        highscore.setOnMouseClicked(event -> {
            System.out.println("Show highscores");
        });
        this.getRootPane().getChildren().add(highscore);
    }
}
