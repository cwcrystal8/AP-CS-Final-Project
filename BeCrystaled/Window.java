import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{
	//------INSTANCE VARIABLES------
	private Container pane;
	private JButton[][] grid;
	private Candy[][] board;
	private int score;
	private int numOfMoves;
	private JButton noMoreMoves;
	private JButton restart;
	private JLabel playerScore;
	private JLabel numMoves;
	private boolean hasSelectedOther;
	private int[] previouslySelectedInfo;

	/*---------------------CONSTRUCTOR---------------------
	sets up Window with a grid with each cell being buttons
	-----------------------------------------------------*/
	public Window(int width, int length){
		this.setTitle("BeCrystaled");
		this.setSize(1000,1000);
		this.setLocation(100,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane = this.getContentPane();
		pane.setLayout(new GridLayout(width,length+1));
        
		grid = new JButton[width][length+1];
		
		for(int i = 0; i < length + 1; i++){ 
            		for(int j = 0; j < width; j++){
		    		grid[j][i]=new JButton("");   
		    		this.add(grid[j][i]);			
				if (i == length + 1){
					this.add(new JLabel());
				}
			}		
			if(i == 0){
				grid[0][length] = new JButton("Restart");
				this.add(grid[0][length]);
			}
		}
		
	}

	//-----------------METHODS-----------------
	public void actionPerformed(ActionEvent e){
	}
	
	private int getScore(){
		return score; //Accessor method for score
	}

	private int getMoves(){
		return numOfMoves; //Accessor method for number of moves
	}

	private char[][] hasConsectutive(String type){
		return new char[1][1];
	}
	
	private void updateBoard(){
	}
	
	private void updateScore(int x, int y, int xLength, int yLength){
	}

	private void moveDown(int x, int y, int xLength, int yLength){
	}

	public boolean isLegalSwap(){
		return true;	
	}
    	
	private void swap(){
	}

	private boolean hasCombination(){
		return true;
	}
	
	private boolean hasCombination(String type){
		return true;
	}

	private int[] findCombination(String type){
		return new int[1];
	}
	
	public void storeInfo(ActionEvent e){
	}
	
	
	
    	public static void main (String[] args) {
    		new Window(9,9);
	}
    	
	//github in terminal was not working
}

