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
    private JButton highscores = new JButton("High Scores");
	
    public StartPage() {
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    home.dispose();
		    new Window(9,9);
		}
	    });

	highscores.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    home.dispose();
		    new HighScoreBoard();
		}
	    });

	backImage = new JLabel();
	backImage.setLayout(new FlowLayout(FlowLayout.CENTER));
	backImage.add(Box.createRigidArea(new Dimension(1000,475)));

	backImage.setIcon(new ImageIcon("StartImage.jpg"));

	start.setPreferredSize(new Dimension(200,50));
	highscores.setPreferredSize(new Dimension(200,50));
	
	start.setLocation(450,525);

	start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	highscores.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
	backImage.add(start);
	backImage.add(Box.createRigidArea(new Dimension(1000,30)));
	backImage.add(highscores);
	pane.add(backImage);
	this.pack();
	this.setVisible(true);
	

	this.setTitle("BeCrystaled");
	this.setSize(1000,1061);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
	new StartPage();
    }
}
