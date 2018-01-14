import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

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
    private static ArrayList<String> types;

    /*---------------------CONSTRUCTOR---------------------
      sets up Window with a grid with each cell being buttons
      -----------------------------------------------------*/
    public Window(int row, int col){
	score = 0;
	numOfMoves = 50;
	restart = new JButton("Restart");
	playerScore = new JLabel("Score: " + score);
	numMoves = new JLabel("Moves: " + numOfMoves);
	hasSelectedOther = false;
	previouslySelectedInfo = new int[3];
	
	this.setTitle("BeCrystaled");
	this.setSize(1000,1000);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	
	pane = this.getContentPane();
	pane.setLayout(new BorderLayout(20,20));

	JPanel grids = new JPanel(new GridLayout(row,col+1));


	//Making initial Candy setup
	grid = new JButton[row][col];
	board = new Candy[row][col];
	Color[] colors = {new Color(202,236,246),
			  new Color(243,201,225),
			  new Color(239,246,202),
			  new Color(202,246,215),
			  new Color(199,184,240)};
	
	String[] pics = {"marshmallow.jpg",
			 "jellybean.png",
			 "gumdrop.jpg",
			 "jollyrancher.jpg",
			 "skittle.png"};

	types = new ArrayList<String>();
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
		btn.setBackground(colors[color]);
		btn.setOpaque(true);
		grid[i][j] = btn;
	    }
	}



	//Adding from grid to GUI
	for(int i = 0; i < row; i++){ 
	    for(int j = 0; j < col; j++){
		grids.add(grid[i][j]);//fill in buttons to grid
	    }		
	}

	JLabel intro = new JLabel("Welcome to BeCrystaled! \n");
	intro.setFont(new Font("Times New Roman", Font.PLAIN, 60));
	pane.add(intro, BorderLayout.NORTH);

	pane.add(new JLabel("        "), BorderLayout.WEST);

	pane.add(grids, BorderLayout.CENTER);

	pane.add(new JLabel("        "), BorderLayout.EAST);

	playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 60));

	JPanel subpane = new JPanel(new GridLayout(1,3,50,50));
	JButton restart = new JButton("Restart");
	
	restart.setFont(new Font("Times New Roman", Font.PLAIN, 60));
	numMoves.setFont(new Font("Times New Roman", Font.PLAIN, 60));

	subpane.add(numMoves);
	subpane.add(restart);
	subpane.add(playerScore);
	subpane.setBorder(new EmptyBorder(10,10,10,10));
	
	pane.add(subpane, BorderLayout.SOUTH);

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
	for (int i = 0; i < 5; i++){
	    if (hasCombination(types.get(i))){
		return true;
	    }
	}
	return false;
    }
	
    public boolean hasCombination(String type){
	for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 6; j++){
		Candy a = board[i][j], b = board[i][j+1], c = board[i][j+2];
		if ((a.getType()).equals(b.getType()) && (b.getType()).equals(c.getType())){
		    return true;
		}
	    }
	}

	for (int i = 0; i < 6; i++){
	    for (int j = 0; j < 9; j++){
		Candy a = board[i][j], b = board[i+1][j], c = board[i+2][j];
		if ((a.getType()).equals(b.getType()) && (b.getType()).equals(c.getType())){
		    return true;
		}
	    }
	}
	return false;
    }

    private int[] findCombination(String type){
	for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 6; j++){
		Candy a = board[i][j], b = board[i][j+1], c = board[i][j+2];
		if ((a.getType()).equals(b.getType()) && (b.getType()).equals(c.getType()) && c.getType().equals(type)){
		    int[] info = {i, j, types.indexOf(type),1};
		    return info;
		}
	    }
	}

	for (int i = 0; i < 6; i++){
	    for (int j = 0; j < 9; j++){
		Candy a = board[i][j], b = board[i+1][j], c = board[i+2][j];
		if ((a.getType()).equals(b.getType()) && (b.getType()).equals(c.getType()) && c.getType().equals(type)){
		    int[] info = {i, j, types.indexOf(type),-1};
		    return info;
		}
	    }
	}
	int[] a = {100,100,100,0};
	return a;
    }
	
    public void storeInfo(ActionEvent e){
    }
	
	
	
    public static void main (String[] args) {
	Window win = new Window(9,9);
    }
    	
}

