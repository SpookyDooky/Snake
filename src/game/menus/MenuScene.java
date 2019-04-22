package game.menus;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class MenuScene extends Scene {

    private int width = 800;
    private int height = 800;

    private Font defaultFont = new Font("arial", 30);
    private Pane rootPane;

    public MenuScene(Pane root){
        super(root);

        this.rootPane = root;
        root.setMinWidth(width);
        root.setMinHeight(height);
    }

    public Pane getRootPane(){
        return this.rootPane;
    }
}
