
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayFrogger extends JFrame {

    public static JLabel lab1;
    public static JLabel lab2;
    public static JLabel lab3;
    public static JLabel lab4;
    public static JLabel labTime;
    private static long startTime;
    public static ThreadTime prova;
    private static int seconds;
    private static int minutes;
    private static int hours;

    public PlayFrogger() {
        setSize(310, 800);
        lab1 = new JLabel("LEVEL");
        lab1.setFont(new Font("Courier New", Font.ITALIC, 18));
        lab2 = new JLabel("♥♥♥♥♥");
        lab3 = new JLabel("SCORE");
        lab3.setFont(new Font("Courier New", Font.TYPE1_FONT, 12));
        lab4 = new JLabel("HIGHSCORE");
        lab4.setFont(new Font("Courier New", Font.TYPE1_FONT, 12));
        PlayFrogger.lab1.setLocation((369 - PlayFrogger.lab1.getWidth()) / 2, 5);
        PlayFrogger.lab1.setForeground(Color.BLUE);

        PlayFrogger.lab3.setLocation((369 - PlayFrogger.lab3.getWidth()), 56);
        PlayFrogger.lab3.setForeground(Color.BLUE);

        PlayFrogger.lab4.setLocation((369 - PlayFrogger.lab4.getWidth()), 46);
        PlayFrogger.lab4.setForeground(Color.RED);
        labTime = new JLabel("0:00:00");
        labTime.setFont(new Font("Courier New", Font.TYPE1_FONT, 12));
        PlayFrogger.labTime.setLocation((369 - PlayFrogger.lab4.getWidth()), 76);
        PlayFrogger.labTime.setForeground(Color.DARK_GRAY);
//        label.setHorizontalAlignment(JLabel.CENTER);

//        panelButtons = new JPanel(new GridLayout(1, 2));
//        GridLayout g = new GridLayout(2, 2);
//        getContentPane().setLayout(g);
        GridLayout g = new GridLayout(2, 2);
        getContentPane().setLayout(g);

        add(lab1);
        add(lab2);
        add(lab3);
        add(lab4);
        add(labTime);

        start();

        add(new FroggerComponent());

        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //lab1.setLocation(75,40);
    }

    public static class ThreadTime extends Thread {

        @Override
        public void run() {

            while (true) {
                long diffTime = System.currentTimeMillis() - startTime;
//                int decSeconds = (int) (diffTime % 1000 / 100);
                seconds = (int) (diffTime / 1000 % 60);
                minutes = (int) (diffTime / 60000 % 60);
                hours = (int) (diffTime / 3600000);
                String s = String.format("%d:%02d:%02d", hours, minutes, seconds);

                labTime.setText(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlayFrogger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void main(String[] args) {
        new PlayFrogger();
    }

    public static void start() {
        startTime = System.currentTimeMillis();
        prova = new ThreadTime();
        prova.start();
    }

    public static double scorePerSeconds() {

        return (double)(1000.0 / (seconds + minutes * 60 + hours * 3600));

    }

}
