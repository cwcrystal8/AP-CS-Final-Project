import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{
	private Container pane;
	private JButton[][] grid;
	
	public Window(int width, int length){
		this.setTitle("BeCrystaled");
		this.setSize(600,400);
		this.setLocation(100,100);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane = this.getContentPane();
		pane.setLayout(new GridLayout(width,length));
        
		grid = new JButton[width][length];
		
		
		for(int i = 0; i < length; i++){ 
            for(int j=0; j < width; j++){
            		grid[j][i]=new JButton("");   
            		this.add(grid[j][i]);
            }
		}
		
		
    }

    public void actionPerformed(ActionEvent e){
    }
    
    public static void main (String[] args) {
    		new Window(3,3);
    }
	//github in terminal was not working
}

