
import javax.swing.*;
import java.awt.*;

public class PlayFrogger extends JFrame {

    public static JLabel lab1;
    

    public PlayFrogger() {
        lab1 = new JLabel("LEVEL");
        lab1.setFont(new Font("Courier New", Font.TYPE1_FONT, 12));
        getContentPane().setLayout(new FlowLayout());
        add(new FroggerComponent());
        add(lab1);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
         //lab1.setLocation(75,40);
    }

    public static void main(String[] args) {
        new PlayFrogger();
    }
        public JLabel getLab() {
        return this.lab1;
    }
}
