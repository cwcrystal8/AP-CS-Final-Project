import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class StartPage extends JFrame {
    private Container pane;
    private JFrame home = new JFrame("Start Page");
    private JButton start = new JButton("Start");
    private JLabel backImage;
	
    public StartPage() {
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    home.dispose();
		    new Window(9,9);
		}
	    });


	backImage = new JLabel();
	backImage.setLayout(new FlowLayout(FlowLayout.CENTER));
	backImage.add(Box.createRigidArea(new Dimension(1000,475)));

	backImage.setIcon(new ImageIcon("StartImage.jpg"));

	start.setPreferredSize(new Dimension(100,50));
	start.setLocation(450,525);
	backImage.add(start);
	pane.add(backImage);
	this.pack();
	this.setVisible(true);
	

	this.setTitle("BeCrystaled");
	this.setSize(1000,1000);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
	new StartPage();
    }
}
