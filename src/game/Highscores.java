package game;

import java.util.ArrayList;

public class Highscores {

    private ArrayList<HighscoreEntry> highscores;

    public Highscores(){
        this.highscores = new ArrayList<>();
    }

    //For now we will only have highscores for one map, but in the future this needs to be compatible with multiple maps.
    public void init(){

    }
}
