import javax.swing.*;
import java.awt.*;

public class StatsPanel extends GeneralPanel{

    private JLabel highScoreLabel;
    private FileInfo fileInfo;
    
    public StatsPanel(){
        fileInfo = new FileInfo();
        
        highScoreLabel= new JLabel("High Score: " + fileInfo.getHighScore());
        highScoreLabel.setBounds(396, 425, 1000, 50);
        highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreLabel.setForeground(Color.decode(hexColours.altForeground));
        highScoreLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
        this.add(highScoreLabel);

    }
}
