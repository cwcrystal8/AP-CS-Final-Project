import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class StartPage extends JFrame {
    private Container pane;
	private JFrame home = new JFrame("Start Page");
	private JButton start = new JButton("Start");
	
	public StartPage() {
	
		pane = this.getContentPane();
		pane.setLayout(new BorderLayout(20,20));
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.dispose();
				new Window(9,9);
			}
		});
		
		JLabel intro = new JLabel("BeCrystaled\n", JLabel.CENTER);
		intro.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		pane.add(intro, BorderLayout.NORTH);
		
		this.setTitle("BeCrystaled");
		this.setSize(1000,1000);
		this.setLocation(100,10);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane.add(start);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new StartPage();
	}
}
