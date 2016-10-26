
import javax.swing.*;
import java.awt.*;

public class PlayFrogger extends JFrame {

    public static JLabel lab1;
    public static JLabel lab2;

    public PlayFrogger() {
        setSize(310,800);
        lab1 = new JLabel("LEVEL");
        lab1.setFont(new Font("Courier New", Font.ITALIC, 18));
        lab2=new JLabel("♥♥♥♥♥");
        GridLayout g=new GridLayout(2,2);
        getContentPane().setLayout(g);
        add(lab1);
        add(lab2);
        add(new FroggerComponent());
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
     
}
