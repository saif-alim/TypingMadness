import javax.swing.*;
import java.awt.event.*;

public class WPMFrame extends JFrame implements ActionListener{

    private GeneralButton startGameButton;
    private GeneralButton restartButton;
    private GeneralButton backButton;
    private GeneralButton altBackButton;
    private GeneralButton changeThemeButton;
    private GeneralButton statsButton;

    private StartGamePanel startGamePanel;
    private WPMPanel wpmPanel;
    private StatsPanel statsPanel;

    private String theme;
    private FileInfo fileInfo;
                                                                       
    public WPMFrame(){

        fileInfo = new FileInfo();
        theme = fileInfo.getTheme();

        makeStartScreen();
        
        this.setTitle("Typing Madness");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        startGameButton.requestFocus();
    }

    // initialises components for the initial screen
    public void makeStartScreen(){
        startGameButton = new GeneralButton("start", theme);
        startGameButton.setLocation(771, 400);
        startGameButton.addActionListener(this);

        restartButton = new GeneralButton("restart", theme);
        restartButton.setLocation(771, 600);
        restartButton.addActionListener(this);

        changeThemeButton = new GeneralButton("change theme", theme);
        changeThemeButton.setLocation(1525, 50);
        changeThemeButton.addActionListener(this);

        backButton = new GeneralButton("back", theme);
        backButton.setLocation(1525, 825);
        backButton.addActionListener(this);

        altBackButton = new GeneralButton("back", theme);
        altBackButton.setLocation(1525, 825);
        altBackButton.addActionListener(this);

        statsButton = new GeneralButton("player stats", theme);
        statsButton.setLocation(771, 470);
        statsButton.addActionListener(this);

        startGamePanel = new StartGamePanel(theme);
        this.add(startGameButton);
        this.add(changeThemeButton);
        this.add(statsButton);
        this.add(startGamePanel);
        
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void removeStartScreen(){
        this.remove(startGamePanel);
        this.remove(changeThemeButton);
        this.remove(statsButton);
        this.remove(startGameButton);
    }

    // initialises components for the game screen
    public void makeGameScreen() {
        wpmPanel = new WPMPanel();
        this.add(restartButton);
        this.add(backButton);
        this.add(wpmPanel);
        wpmPanel.typingTextField.requestFocus();
        
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void removeGameScreen(){
        this.remove(wpmPanel);
        this.remove(restartButton);
        this.remove(backButton);
    }

    // initialises components for the statistics screen
    public void makeStatsScreen(){
        statsPanel = new StatsPanel();
        this.add(altBackButton);
        this.add(statsPanel);

        SwingUtilities.updateComponentTreeUI(this);
        altBackButton.requestFocus();
    }

    public void removeStatsScreen(){
        this.remove(statsPanel);
        this.remove(altBackButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == startGameButton) {
            removeStartScreen();
            makeGameScreen();
        }

        if (e.getSource() == restartButton) {
            removeGameScreen();
            makeGameScreen();
        }

        if (e.getSource() == backButton) {
            removeGameScreen();
            makeStartScreen();
            startGameButton.requestFocus();
        }

        if (e.getSource() == altBackButton) { // for the stats panel
            removeStatsScreen();
            makeStartScreen();
            statsButton.requestFocus();
        }

        if (e.getSource() == changeThemeButton){

            if (theme.equals("light")) {
                theme = "dark";
            }
            else {
                theme = "light";
            }
            removeStartScreen();
            makeStartScreen();
            changeThemeButton.requestFocus();

            fileInfo.setTheme(theme);
        }

        if (e.getSource() == statsButton){
            removeStartScreen();
            makeStatsScreen();
        }
    }

    public static void main(String[] args) {
        new WPMFrame();
    }
}
