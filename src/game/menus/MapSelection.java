package game.menus;

import game.SnakeGame;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MapSelection extends MenuScene {

    public MapSelection(Pane root){
        super(root);
        setupBackButton();
        setupTitle();
        setupMapButton();
    }

    private void setupTitle(){
        Text title = new Text();
        title.setText("Map selection");

        title.setWrappingWidth(800);
        title.setTextAlignment(TextAlignment.CENTER);

        title.setFont(new Font("arial BOLD", 40));
        title.setLayoutY(75);

        this.getRootPane().getChildren().add(title);
    }

    private void setupMapButton(){
        Button mapButton = new Button();
        mapButton.setText("Standard");
        mapButton.setMinWidth(300);
        mapButton.setMaxWidth(300);
        mapButton.setMinHeight(50);
        mapButton.setMaxHeight(50);
        mapButton.setLayoutX(250);
        mapButton.setLayoutY(150);

        mapButton.setFont(this.getMenuFont());

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

        backButton.setFont(this.getMenuFont());
        backButton.setOnMouseClicked(event -> {
            SnakeGame.getGameInstance().getMainStage().setScene(new MainMenu(new Pane()));
        });

        this.getRootPane().getChildren().add(backButton);
    }
}
