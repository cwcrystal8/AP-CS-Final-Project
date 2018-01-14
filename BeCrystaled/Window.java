import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class Window extends JFrame implements ActionListener, MouseListener{
    //------INSTANCE VARIABLES------
    private Container pane;
    private JButton[][] grid;
    private Candy[][] board;
    private JPanel grids;
    private int score;
    private int numOfMoves;
    private JButton noMoreMoves;
    private JButton restart;
    private JLabel playerScore;
    private JLabel numMoves;
    private boolean hasSelectedOther;
    private int[] previouslySelectedInfo;
    private static ArrayList<String> types;
    private static Color[] colors = {new Color(202,236,246),
								     new Color(243,201,225),
								     new Color(239,246,202),
								     new Color(202,246,215),
								     new Color(199,184,240)};
    private static String[] pics = {"marshmallow.jpg",
								    "jellybean.png",
								    "gumdrop.jpg",
								    "jollyrancher.jpg",
								    "skittle.png"};

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
		previouslySelectedInfo = new int[2];
			
		this.setTitle("BeCrystaled");
		this.setSize(1000,1000);
		this.setLocation(100,10);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			
		pane = this.getContentPane();
		pane.setLayout(new BorderLayout(20,20));
		
		grids = new JPanel(new GridLayout(row,col));
		
		
		//Making initial Candy setup
		grid = new JButton[row][col];
		board = new Candy[row][col];
		
		       
		
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
	
		//Clearing existing combinations
		int numIter = 0;
		while(hasCombination()){
		    numIter++;
		    if (numIter > 100){
			for (int i = 0; i < row; i++){
			    for (int j = 0; j < col; j++){
			    		board[i][j] = new RegularCandy();
			    }
			}		
		    }
		    System.out.println("Still making!");
		    for (int x = 0; x < 5; x++){
				int[] comb = findCombination(types.get(x));
				if (comb[3] == 1){ //horizontal
				    boolean isConsecutive = true;
				    int len = 0;
				    for (int j = comb[1]; isConsecutive && j < board.length; j++){
						if(board[comb[0]][j].getType().equals(board[comb[0]][comb[1]].getType())){
						    len++;
						}
						else {
						    isConsecutive = false;
						}
				    }
				    moveDown(comb[0],comb[1],len,0);
				}
				else if (comb[3] == -1){ //vertical
				    boolean isConsecutive = true;
				    int len = 0;
				    for (int i = comb[0]; isConsecutive && i < 9; i++){
						if(board[i][comb[1]].getType().equals(board[comb[0]][comb[1]].getType())){
						    len++;
						}
						else{
						    isConsecutive = false;
						}
				    }
				    moveDown(comb[0] + len - 1, comb[1], 0, len);
				}
		    }
		}
		
		
		for (int i = 0; i < row; i++){
		    for (int j = 0; j < col; j++){
				String candy = board[i][j].getType();
				int color = types.indexOf(candy);
				JButton btn = new JButton(new ImageIcon(pics[color]));
				btn.setBackground(colors[color]);
				btn.setOpaque(true);
				btn.addActionListener(this);
				btn.addMouseListener(this);
				grid[i][j] = btn;
		    }
		}
		
		
		
		//Adding from grid to GUI
		for(int i = 0; i < row; i++){ 
		    for(int j = 0; j < col; j++){
		    		grids.add(grid[i][j]);//fill in buttons to grid
		    }		
		}
		
		JLabel intro = new JLabel("BeCrystaled\n");
		intro.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		pane.add(intro, BorderLayout.NORTH);
		
		pane.add(new JLabel("        "), BorderLayout.WEST);
		
		pane.add(grids, BorderLayout.CENTER);
		
		pane.add(new JLabel("        "), BorderLayout.EAST);
		
		playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		
		JPanel subpane = new JPanel(new GridLayout(1,3,50,50));
		JButton restart = new JButton("Restart");
		restart.addActionListener(this);
			
		restart.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		numMoves.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		
		subpane.add(numMoves);
		subpane.add(restart);
		subpane.add(playerScore);
		subpane.setBorder(new EmptyBorder(10,10,10,10));
			
		pane.add(subpane, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
			
			
    }

    //-----------------METHODS-----------------
    public void actionPerformed(ActionEvent e){
		if(hasSelectedOther && isLegalSwap(e)){
		    swap(e);
		    hasSelectedOther = false;
		}
		else {
		    storeInfo(e);
		    hasSelectedOther = true;
		}
		updateBoard();
    }
	
    private int getScore(){
    		return score; //Accessor method for score
    }

    private int getMoves(){
    		return numOfMoves; //Accessor method for number of moves
    }

    private char[][] hasConsecutive(String type){
    		
    		return new char[1][1];
    }
	
    private void updateBoard(){
		pane.remove(grids);
		for (int i = 0; i < grid.length; i++){
		    for (int j = 0; j < grid[i].length; j++){
				String candy = board[i][j].getType();
				int color = types.indexOf(candy);
				JButton btn = new JButton(new ImageIcon(pics[color]));
				btn.setBackground(colors[color]);
				btn.setOpaque(true);
				btn.addActionListener(this);
				btn.addMouseListener(this);
				grid[i][j] = btn;
		    }
		}

		grids = new JPanel(new GridLayout(grid.length,grid[1].length));
		
		//Adding from grid to GUI
		for(int i = 0; i < grid.length; i++){ 
		    for(int j = 0; j < grid[i].length; j++){
		    		grids.add(grid[i][j]);//fill in buttons to grid
		    }		
		}
	
		pane.add(grids, BorderLayout.CENTER);
		grids.revalidate();
		grids.repaint();
		pane.setVisible(true);
    }
	
    public void updateScore(int x, int y, int xLength, int yLength){
		int num = 0;
		for (int i = 0; i < (xLength + yLength); i++){
		    Candy a = board[x][y];
		    num += a.getScoreWorth();
		    if (xLength > 0){
		    		x++;
		    }
		    else if (yLength > 0){
		    		y++;
		    }
		}
		score+= num;
		playerScore.setText("Score: " + score);	
    }

    private void moveDown(int x, int y, int xLength, int yLength){
		if (xLength > 0){
		    for (int i = 0; i < xLength; i++){
				for (int j = x; j > 0; j--){
				    board[j][y + i] = board[j - 1][y + i];
				}
			board[0][y + i] = new RegularCandy();
		    }
		}
		else if (yLength > 0){
		    int tempIncrement = 0;
		    for (int i =  x - yLength; i >= 0; i--){
				board[x - tempIncrement][y] = board[i][y];
				tempIncrement++;
		    }
		    for (int i = x - tempIncrement; i >= 0; i--){
		    		board[i][y] = new RegularCandy();
		    }
		}	     
    }

    public boolean isLegalSwap(ActionEvent e){
		int[] a = new int[2], b = previouslySelectedInfo;
	    JButton btn = (JButton)e.getSource();
		for (int i = 0; i < grid.length; i++){
		    for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] == btn){
				    a[0] = i;
				    a[1] = j;
				}
		    }
		}
		return (!(board[a[0]][a[1]].getType().equals(board[b[0]][b[1]].getType()))) &&
		       (1 == Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) +
		    		   			   (a[1] - b[1]) * (a[1] - b[1]))) &&
		       willMakeCombination(e);
    }

    private boolean willMakeCombination(ActionEvent e){
		swap(e);
		if (hasCombination()){
		    swap(e);
		    return true;
		}
		return false;	
    }
    	
    private void swap(ActionEvent e){
		int[] a = new int[2], b = previouslySelectedInfo;
	    JButton btn = (JButton)e.getSource();
		for (int i = 0; i < grid.length; i++){
		    for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] == btn){
				    a[0] = i;
				    a[1] = j;
				}
		    }
		}
		Candy temp = board[a[0]][a[1]];
		board[a[0]][a[1]] = board[b[0]][b[1]];
		board[b[0]][b[1]] = temp;
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
		    for (int j = 0; j < 7; j++){
				Candy a = board[i][j], b = board[i][j+1], c = board[i][j+2];
				if ((a.getType()).equals(b.getType()) && (b.getType()).equals(c.getType())){
				    return true;
				}
		    }
		}
	
		for (int i = 0; i < 7; i++){
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
		JButton btn = (JButton)e.getSource();
		for (int i = 0; i < grid.length; i++){
		    for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] == btn){
				    previouslySelectedInfo[0] = i;
				    previouslySelectedInfo[1] = j;
				}
		    }
		}
    }


    public void mouseEntered(MouseEvent e){
    }
	
    public void mouseExited(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseClicked(MouseEvent e){
    }

    public void mousePressed(MouseEvent e){
    }
    
    public static void main (String[] args) {
    		Window win = new Window(9,9);
    }
    	
}


