import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GeneralButton extends JButton implements FocusListener{
    
    private Border border;
    private HexColours hexColours;

    public GeneralButton(String text, String theme){

        hexColours = new HexColours(theme);
        setFocusPainted(false);
        border = BorderFactory.createLineBorder(Color.decode(hexColours.background), 0);

        this.addFocusListener(this);
        this.setSize(250, 60);
        this.setBackground(Color.decode(hexColours.altForeground));
        this.setForeground(Color.decode(hexColours.altBackground));
        this.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        this.setBorder(border);
        this.setText(text);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(Color.decode(hexColours.altBackground));
        setForeground(Color.decode(hexColours.altForeground));
        border = BorderFactory.createLineBorder(Color.white, 3);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(Color.decode(hexColours.altForeground));
        setForeground(Color.decode(hexColours.altBackground));
        border = BorderFactory.createLineBorder(Color.decode(hexColours.background), 0);
    }

    
}
