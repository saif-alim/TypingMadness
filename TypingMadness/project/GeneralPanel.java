import java.awt.*;
import javax.swing.*;

public class GeneralPanel extends JPanel{

    protected HexColours hexColours;

    public GeneralPanel(){
        hexColours = new HexColours();
        
        this.setPreferredSize(new Dimension(1792, 900));
        this.setBackground(Color.decode(hexColours.background));
        this.setLayout(null);
    }
}
