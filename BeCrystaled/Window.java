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
		pane.setLayout(new GridLayout(width,length));
        
		grid = new JButton[width][length];
		
		for(int i = 0; i < length; i++){ 
            	for(int j=0; j < width; j++){
		    		grid[j][i]=new JButton("");   
		    		this.add(grid[j][i]);
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
	}
	
	private void updateBoard(){
	}
	
	private void updateScore(int x, int y, int xLength, int yLength){
	}

	private void moveDown(int x, int y, int xLength, int yLength){
	}

	public boolean isLegalSwap(){
	}
    	
	private void swap(){
	}

	private boolean hasCombination(){
	}
	
	private boolean hasCombination(String type){
	}

	private int[] findCombination(String type){
	}
	
	public void storeInfo(ActionEvent e){
	}
	
	
	
    	public static void main (String[] args) {
    		new Window(9,9);
	}
    	
	//github in terminal was not working
}

