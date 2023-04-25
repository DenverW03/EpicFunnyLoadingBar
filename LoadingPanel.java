import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class LoadingPanel extends JPanel{
    private int timesPerSecond;
    private int x, y, width, height;
    /**
     * Constructor for the class
     */
    public LoadingPanel(){
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 50));
        this.x = 5; // not to be changed
        this.y = 5; // not to be changed
        this.height = 40; // not to be changed
        this.width = 0; // to be incremented
        this.timesPerSecond = 10;
        Timer timer = new Timer(1000/timesPerSecond, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				repaint();
                if(width == 390){width = 0;}
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