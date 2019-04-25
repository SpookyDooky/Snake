package game.menus;

import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenu extends MenuScene{

    public MainMenu(Pane rootpane){
        super(rootpane);
        setupPlayButton();
        setupHighscoreButton();
        setupExitButton();
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

        playButton.setFont(this.getMenuFont());

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

        highscore.setFont(this.getMenuFont());

        highscore.setOnMouseClicked(event -> {
            System.out.println("Show highscores");
        });
        this.getRootPane().getChildren().add(highscore);
    }

    private void setupExitButton(){
        Button exit = new Button();
        exit.setText("Exit");

        exit.setMinHeight(50);
        exit.setMaxHeight(50);
        exit.setMinWidth(300);
        exit.setMaxWidth(300);
        exit.setLayoutX(250);
        exit.setLayoutY(325);

        exit.setFont(this.getMenuFont());

        exit.setOnMouseClicked(event -> {
            System.exit(1);
        });
        this.getRootPane().getChildren().add(exit);
    }
}