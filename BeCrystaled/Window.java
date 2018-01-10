import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
    public Window(int row, int col){
	this.setTitle("BeCrystaled");
	this.setSize(1000,1000);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	this.setResizable(false);
	
	
	
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(row,col+1));


	//Making initial Candy setup
	grid = new JButton[row][col+1];
	board = new Candy[row][col];
	/*	Color[] colors = {new Color(202,236,246),
			  new Color(202,246,215),
			  new Color(239,246,202),
			  new Color(243,201,225),
			  new Color(199,184,240)};*/
	String[] pics = {"marshmallow.jpg","jellybean.png","gumdrop.jpg","jollyrancher.jpg","skittle.png"};
	ArrayList<String> types = new ArrayList<String>();
	types.add("Marshmallow");
	types.add("JellyBean");
	types.add("GumDrop");
	types.add("JollyRancher");
	types.add("Skittle");

	

	for (int i = 0; i < row; i++){
	    for (int j = 0; j < col; j++){
		board[i][j] = new RegularCandy();
	    }
	}

	for (int i = 0; i < row; i++){
	    for (int j = 0; j < col; j++){
		String candy = board[i][j].getType();
		int color = types.indexOf(candy);
		JButton btn = new JButton(new ImageIcon(pics[color]));
		//	btn.setBackground(colors[color]);
		btn.setOpaque(true);
		grid[i][j] = btn;
	    }
	}



	//Adding from grid to GUI
	for(int i = 0; i < row; i++){ 
	    for(int j = 0; j < col; j++){
	    		if (i == 0) {
	    			this.add(new JLabel(""));
	    		}
	    		else if(i == row-2 && j == col-2){
				    grid[1][col-2] = new JButton("Restart");
				    this.add(grid[1][col-2]);
			}
	    		else if(i == 1 && j == col-3){
				    this.add(new JLabel("Score:"));
			}
	    		else if (j == 0) {
	    			this.add(new JLabel(""));
	    		}
	    		else if (j == col-1 || j == col-2 || j ==col-3 || j ==col-4) {
	    			this.add(new JLabel(""));
	    		}
	    		else if (i == row-1){
				    this.add(new JLabel(""));
			}
			else {
			    this.add(grid[i][j]);
			}
	    }		
	}

	this.setVisible(true);

	
		
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
	new Window(11,14);
    }
    	
    //github in terminal was not working
}

