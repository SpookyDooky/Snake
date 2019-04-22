package game.menus;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class MenuScene extends Scene {

    private int width = 1000;
    private int height = 1000;

    private Font defaultFont = new Font("arial", 30);
    private Pane rootPane;

    public MenuScene(Pane root){
        super(root);

        this.rootPane = root;
        root.setMinWidth(width);
        root.setMinHeight(height);
    }
}
