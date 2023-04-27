import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
public class LoadingPanel extends JPanel{
    private double timesPerSecond;
    private int x, y, width, height;
    /**
     * Default constructor for the class
     */
    public LoadingPanel(){
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 50));
        this.x = 5; // not to be changed
        this.y = 5; // not to be changed
        this.height = 40; // not to be changed
        this.width = 0; // to be incremented
        this.timesPerSecond = 10; // the default amount of time
        Timer timer = new Timer(1000/(int)timesPerSecond, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				repaint();
                if(width == 390){
                    System.out.println("LOADED!");
                    System.exit(0);
                }
                width = width + 1;
			}
		});
		timer.start();
    }
    /**
     * Constructor for when terminal arguments are present
     * @param s the number of minutes for the loading bar to take to complete
     */
    public LoadingPanel(String s){
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 50));
        this.x = 5; // not to be changed
        this.y = 5; // not to be changed
        this.height = 40; // not to be changed
        this.width = 0; // to be incremented
        int minutes = Integer.parseInt(s);
        this.timesPerSecond = ((double)minutes * 60) / 390;
        int delay = (int)Math.floor(1000 * this.timesPerSecond); // how often the timer activates
        Timer timer = new Timer(delay, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				repaint();
                if(width == 390){
                    System.out.println("LOADED!");
                    System.exit(0);
                }
                width = width + 1;
			}
		});
		timer.start();
    }
    /**
     * Method that draws to the screen
     */
    @Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
        g.setColor(Color.RED);
        DrawBar(g);
	}
    /**
     * paints the loading bar to the graphics object given to it
     * @param g the passed graphics object
     */
    public void DrawBar(Graphics g){
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}