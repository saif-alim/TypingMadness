import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class StartGamePanel extends GeneralPanel{

    private JLabel gameTitle;
    HexColours hexColours;

    public StartGamePanel(String theme){

        hexColours = new HexColours(theme);

        this.setPreferredSize(new Dimension(1792, 900));
        this.setBackground(Color.decode(hexColours.background));

        gameTitle = new JLabel("Typing Madness");
        gameTitle.setBounds(396, 200, 1000, 100);
        gameTitle.setForeground(Color.decode(hexColours.altForeground));
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gameTitle.setVerticalAlignment(SwingConstants.CENTER);
        gameTitle.setFont(new Font("Book Antiqua", Font.PLAIN, 24));
        this.add(gameTitle);
    }
}
