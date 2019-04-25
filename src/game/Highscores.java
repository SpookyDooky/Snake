package game;

import java.io.*;
import java.util.ArrayList;

public class Highscores {

    private ArrayList<HighscoreEntry> highscores;

    public Highscores(){
        this.highscores = new ArrayList<>();
    }

    //For now we will only have highscores for one map, but in the future this needs to be compatible with multiple maps.

    /**
     * For initializing the highscores
     */
    public void init(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src" + File.separator + "highscores" + File.separator + "highscore")));
            int amount = Integer.valueOf(reader.readLine());

            for(int x = 0; x < amount;x++){
                String line = reader.readLine();
                String[] splitted = line.split(" ");

                HighscoreEntry entry = new HighscoreEntry(splitted[0],Integer.valueOf(splitted[1]));
                this.highscores.add(entry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addHighscore(String name, int score){
        HighscoreEntry newEntry = new HighscoreEntry(name,score);
        this.highscores.add(newEntry);
    }
}
