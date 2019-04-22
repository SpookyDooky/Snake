package game.menus;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainMenu extends MenuScene{

    public MainMenu(Pane rootpane){
        super(rootpane);
        setupPlayButton();
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
            //Map selection screen
        });
        this.getRootPane().getChildren().add(playButton);
    }
}
