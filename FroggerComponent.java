import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FroggerComponent extends JComponent implements KeyListener, Runnable
{
	private FroggerLevelEngine engine;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	public static Vector<FroggerLevel> levels = new Vector();
	private int level = 0;
        //private JLabel l;
        
        //creo playfrogger
        
        //PlayFrogger pf = new PlayFrogger();

	public FroggerComponent()
	{
		super();
		levelInit();
		engine = new FroggerLevelEngine(levels.get(level));
 		setPreferredSize(new Dimension(engine.WIDTH, engine.HEIGHT));

 		addKeyListener(this);
 		Thread run = new Thread(this);
 		run.start();
	}

	public void levelInit()
	{
		levels.add(new FroggerLevel(
			new int[]{1,1,1},
			new String[]{"LLL       LLL       ", "RRRR     RRRR     RRRR     ",
				"RR  BB     LL  MM     "}));

		levels.add(new FroggerLevel(
			new int[]{2,1,2,1,2},
			new String[]{"RR         L  ", "BB  LL  RR     ", "    RR    MM     ",
				"MMM     MMM     ", "RR      L     "}));

		levels.add(new FroggerLevel(
			new int[]{1,1,1,1,1,1,1},
			new String[]{"RR     RR     RR     ", "B   B   B   B   B   ",
				"MMM   MMM     MMM    ", "RR     RR     RR     ",
				"B   B   B   B   B   B   ", "MMM   MMM     MMM    L ",
				"   BBB    BBB L    BBB"}));

		levels.add(new FroggerLevel(
			new int[]{1,1,2,2,3,2,1},
			new String[]{"RR     LL     B   ", "LLL      BB   R    ",
				"RRR      LL        ", "MMM        MM    ", "L          L      ",
				"RR     L      M     ", "RRR    BL       "}));

		levels.add(new FroggerLevel(
			new int[]{1,2,3,4,5},
			new String[]{"BB  L    RRR    M", "RR B  MMM     L    ",
				"MM     LL     BB     ", "M      L      BB      ",
				"LL            "}));

		levels.add(new FroggerLevel(
			new int[]{1,3,4,3,1,2,3,4,5},
			new String[]{"MMM   LL     RR      ", "BBB       LL    RR    ",
			"BB        LL         ", "BBB       MM    MM   ", "MMM  LL  B    R  L B ",
			"MM  RR  LL  BB  LL  ", "BBB     LL  MMMM    ", "L    L     LLL     "}));
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(20);
			}
			catch(Exception ex)
			{
			}
			requestFocus();
                    
                    try {
                        update();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FroggerComponent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		synchronized(g)
		{
			engine.draw(g);
		}
	}

	public void update() throws InterruptedException
	{
		if(upPressed)
			engine.moveUp();
		if(downPressed)
			engine.moveDown();
		if(leftPressed)
			engine.moveLeft();
		if(rightPressed)
			engine.moveRight();

		engine.update();

		if(engine.getState() == FroggerState.WON)
		{
			level++;
			if(level >= levels.size())
			{
				JOptionPane.showMessageDialog(this, "You have beaten this game.");
				System.exit(0);
			}
			engine = new FroggerLevelEngine(levels.get(level));
		}
                
                if(engine.getState() == FroggerState.HIT){
				engine = new FroggerLevelEngine(levels.get(level));
                }
//                
//                if(levels.get(level))
//                {
//                
//                }
                        if(level==0)
                        {
//    JLabel l = new JLabel();
//    l = pf.getLab();
//    l.setText("1");
                            PlayFrogger.lab1.setText("LEVEL 1 - Easy");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                            PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                        
                           PlayFrogger.lab1.setForeground(Color.BLUE);
//                            PlayFrogger.lab1.setFont(new Font("Courier New", Font.ITALIC, 12));
                            
                            }
                        else if(level==1){
                        PlayFrogger.lab1.setText("LEVEL 2 - Easy");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                            PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                         
                            PlayFrogger.lab1.setForeground(Color.RED);
                            
                        
                        }
                        
                        else if(level==2){
                        PlayFrogger.lab1.setText("LEVEL 3 - Medium");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                           PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                         
                            PlayFrogger.lab1.setForeground(Color.GREEN);
                            
                        
                        }
                        
                        else if(level==3){
                        PlayFrogger.lab1.setText("LEVEL 4 - Medium");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                           PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                           
                            PlayFrogger.lab1.setForeground(Color.MAGENTA);
                            
                        
                        }
                        
                        else if(level==4){
                        PlayFrogger.lab1.setText("LEVEL 5 - Difficult");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                            PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                          
                            PlayFrogger.lab1.setForeground(Color.PINK);
                           
                        
                        }
                        
                        else if(level==5){
                        PlayFrogger.lab1.setText("LEVEL 6 - Difficult");
                            //PlayFrogger.lab1.setHorizontalAlignment(JLabel.CENTER);
                            //PlayFrogger.lab1.setLocation(200,200);
                            PlayFrogger.lab1.setLocation((369-PlayFrogger.lab1.getWidth())/2,5);                           
                            PlayFrogger.lab1.setForeground(Color.GRAY);
                            
                        
                        }
	}

	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_UP)
			upPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_SPACE)
		{
//			if(engine.getState() == FroggerState.HIT)
//				engine = new FroggerLevelEngine(levels.get(level));
//		}
	}
        
        }

	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_UP)
			upPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = false;
	}

	public void keyTyped(KeyEvent ke)
	{
	}
}