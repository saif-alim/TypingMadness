import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class WPMPanel extends GeneralPanel implements KeyListener{
    private JLabel wordsToType;
    protected JTextField typingTextField;
    private JLabel wpmLabel;
    private JLabel wpm;
    private JLabel accuracyLabel;
    private JLabel accuracy;
    private JLabel timeLabel;
    private JLabel time;
    private JLabel highScoreLabel;
    private Border border;

    protected static ArrayList<String> sentences;
    private String wordsTyped = "";
    private String randomSentence;
    private Random random = new Random();

    private int enterPressCount = 0;
    private int pressCount = 0;
    private int wInSentenceCount = 0;
    private int wOutSentenceCount = 0;
    private ArrayList<Integer> lastTwoChars;

    private WPMCalculations wpmCalculations;
    private FileInfo fileInfo;

    public WPMPanel(){

        fileInfo = new FileInfo();
        
        lastTwoChars = new ArrayList<>();
        lastTwoChars.add(0);
        lastTwoChars.add(0);
        sentences = fileInfo.getWPMTexts();
        wpmCalculations = new WPMCalculations();

        this.setPreferredSize(new Dimension(1792, 900));
        this.setBackground(Color.decode(hexColours.background));
        this.setLayout(null);

        wordsToType = new JLabel(); //words for user to type
        wordsToType.setBounds(396, 200, 1000, 200);
        wordsToType.setForeground(Color.decode(hexColours.altForeground));
        wordsToType.setVerticalAlignment(SwingConstants.BOTTOM);
        wordsToType.setFont(new Font("Book Antiqua", Font.PLAIN, 24));
        this.add(wordsToType);

        typingTextField = new JTextField(""); // area for user to type
        typingTextField.setBounds(396, 425, 1000, 50);
        typingTextField.setBackground(Color.decode(hexColours.altBackground));
        typingTextField.setForeground(Color.decode(hexColours.foreground));
        typingTextField.addKeyListener(this);
        typingTextField.setFont(new Font("Book Antiqua", Font.PLAIN, 24));
        border = BorderFactory.createLineBorder(Color.decode(hexColours.background));
        typingTextField.setCaretColor(Color.decode(hexColours.foreground));
        typingTextField.setBorder(border);
        this.add(typingTextField);
        
        wpmLabel = new JLabel("wpm: "); 
        wpmLabel.setForeground(Color.decode(hexColours.altForeground));
        wpmLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        wpmLabel.setBounds(396, 480, 100, 25);
        this.add(wpmLabel);

        wpm = new JLabel(""); // to display wpm
        wpm.setForeground(Color.decode(hexColours.foreground));
        wpm.setFont(new Font("Book Antiqua", Font.PLAIN, 46));
        wpm.setBounds(416, 505, 100, 60);
        this.add(wpm);

        accuracyLabel = new JLabel("accuracy: "); // to display accuracy
        accuracyLabel.setBounds(806, 480, 300, 25);
        accuracyLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        accuracyLabel.setForeground(Color.decode(hexColours.altForeground));
        this.add(accuracyLabel);

        accuracy = new JLabel(""); // to display wpm
        accuracy.setForeground(Color.decode(hexColours.foreground));
        accuracy.setFont(new Font("Book Antiqua", Font.PLAIN, 46));
        accuracy.setBounds(826, 505, 250, 60);
        this.add(accuracy);

        timeLabel = new JLabel("time: "); //to display time
        timeLabel.setBounds(1251, 480, 300, 25);
        timeLabel.setForeground(Color.decode(hexColours.altForeground));
        timeLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
        this.add(timeLabel);

        time = new JLabel(""); // to display wpm
        time.setForeground(Color.decode(hexColours.foreground));
        time.setFont(new Font("Book Antiqua", Font.PLAIN, 46));
        time.setBounds(1271, 505, 250, 60);
        this.add(time);

        highScoreLabel = new JLabel("");
        highScoreLabel.setBounds(396, 225, 1000, 65);
        highScoreLabel.setForeground(Color.decode(hexColours.altForeground));
        highScoreLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 52));
        highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(highScoreLabel);

        setRandomSentence();
    }
    
    public void setRandomSentence(){
        randomSentence = sentences.get(random.nextInt(sentences.size()));
        // randomSentence = sentences.get(11); // for testing purposes
        countSentences(randomSentence);
        wordsToType.setText("<html>" + randomSentence+ "</html>"); 
    }

    public void  countSentences(String sentence){
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '.' || sentence.charAt(i) == '?') {
                wOutSentenceCount++;
            }
        }
    }

    public void setWPMResultLabels(){
        wpm.setText(String.valueOf(wpmCalculations.getWPM()));
        accuracy.setText(String.format("%.2f", wpmCalculations.getAccuracy()) + "%");
        time.setText(String.format("%.2f", wpmCalculations.getElapsedSeconds()) + "s");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // uses keyChar
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // uses keyCode
        /**
        * full stop     == 46
        * question mark == 47
        * space bar     == 32
        * shift         == 16
        * enter         == 10
        */

        //does not record shift key presses
        if (e.getKeyCode() != 16){
            lastTwoChars.add(0, e.getKeyCode());
            if (lastTwoChars.size() > 2){
                lastTwoChars.remove(2); // prevents the ArrayList from becoming unecessarily large
            }
        }

        //runs when sentence has been typed (full stop and space pressed consecutively)
        if ((lastTwoChars.get(1) == 46 || lastTwoChars.get(1) == 47) && lastTwoChars.get(0) == 32 && e.getKeyCode() != 16){ 
            wInSentenceCount++;
            wordsTyped += typingTextField.getText();
            typingTextField.setText("");

            if (wInSentenceCount == wOutSentenceCount){
                wpmCalculations.endTest(wordsTyped);
                typingTextField.setEditable(false);
                if (wpmCalculations.getWPM() > fileInfo.getHighScore()){ //checks if the highscore is beat
                    fileInfo.setHighScore(wpmCalculations.getWPM());
                    highScoreLabel.setText("New High Score!! \n" + fileInfo.getHighScore() + "wpm");
                }
                setWPMResultLabels();
            }
        }

        // starts the test when the first alphabetical letter is pressed
        if (pressCount == 0 && e.getKeyCode() >= 65 && e.getKeyCode() <= 90){
            pressCount++;
            if (pressCount == 1){ // runs when first letter is pressed
                wpmCalculations.startTest(randomSentence);
            }
            pressCount++;
        }

        // ends the test if the user presses enter
        if (enterPressCount == 0 && e.getKeyCode() == 10){
            enterPressCount++;
            wpmCalculations.endTest(wordsTyped);
            typingTextField.setEditable(false);
            setWPMResultLabels();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 
    }

}