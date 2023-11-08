import java.io.*;
import java.util.ArrayList;

public class FileInfo {

    /**
     * when the program starts - copy the text file into an arrayList. 
     * then when it closes copy everything in the arrayList back into the text file.
     */

    private BufferedReader br;
    private BufferedWriter bw;

    private String theme;
    private int highScore;

    private ArrayList<String> wpmTextList;

    public FileInfo(){
        // imports the text file into the ArrayList wpmTextList
        try {
            br = new BufferedReader(new FileReader("WPMTexts.txt"));
            String line;
            wpmTextList = new ArrayList<>();
            while ((line = br.readLine()) != null){
                wpmTextList.add(line);
            }
        } catch (Exception e){
            System.err.println("Error: Action could not be completed");
            System.err.println(e);
        }
    }

    public String getTheme(){
        try {
            br = new BufferedReader(new FileReader("WPMInfo.txt"));
            theme = br.readLine();
            br.close();
        } catch(Exception e) {
            System.err.println("failed to get theme");
            System.err.println(e);
            theme = "dark";
        }
        return theme;
    }

    public void setTheme(String theme){
        try {
            br = new BufferedReader(new FileReader("WPMInfo.txt"));
            String highScoreHolder = br.readLine();
            highScoreHolder = br.readLine();

            bw = new BufferedWriter(new FileWriter("WPMInfo.txt"));
            bw.write(theme + "\n");
            bw.write(highScoreHolder);
            bw.close();
        } catch(Exception e) {
            System.err.println("failed to set theme");
            System.err.println(e);
            theme = "dark";
        }
    }

    public int getHighScore(){
        try {
            br = new BufferedReader(new FileReader("WPMInfo.txt"));

            String s = br.readLine();
            s = br.readLine();
            highScore = Integer.parseInt(s);
            br.close();
            return highScore;
        } catch (Exception e){
            System.err.println("failed to get high score");
            System.err.println(e);
            return 0;
        }
    }

    public void setHighScore(int hs){
        try {
            br = new BufferedReader(new FileReader("WPMInfo.txt"));
            String themeHolderString = br.readLine();

            bw = new BufferedWriter(new FileWriter("WPMInfo.txt"));
            bw.write(themeHolderString + "\n");
            String hScore = Integer.toString(hs);
            bw.write(hScore);

            br.close();
            bw.close();
        } catch (Exception e){
            System.err.println("failed to set high score");
            System.err.println(e);
        }
    }
    
    public ArrayList<String> getWPMTexts(){
        return wpmTextList;
    }
    
    public String getWPMTexts(int index){
        return wpmTextList.get(index);
    }
}
