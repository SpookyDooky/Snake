package game.menus;

import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HighscoreMenu extends MenuScene{

    public HighscoreMenu(Pane root) {
        super(root);
        setupTitle();
        setupBackButton();
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
