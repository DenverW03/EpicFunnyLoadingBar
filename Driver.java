import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver{
    private static JFrame frame;
    private static LoadingPanel lp;
    /**
     * Main method for the program, drives execution
     * @param args the terminal arguments fed in to the program
     */
    public static void main(String[] args){
        frame = new JFrame("Loading!!!");
        lp = new LoadingPanel();
        frame.setVisible(true);
        frame.add(lp);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}