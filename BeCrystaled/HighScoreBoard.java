import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import java.io.File;
import java.io.*;

public class HighScoreBoard extends JFrame implements ActionListener{
    private Container pane;
    private JLabel scoreboard;
    private JTextField name;
    private static ArrayList<String> names;
    private static ArrayList<Integer> scores;
    private int currentScore;
    private JLabel[][] table;

    public HighScoreBoard(){
	this(-1);
    }
    
    public HighScoreBoard(int score){
	this.setTitle("High Score Board");
	this.setSize(1000,1000);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);

	names = new ArrayList<String>();
	scores = new ArrayList<Integer>();
	currentScore = score;
	table = new JLabel[11][2];

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

	scoreboard = new JLabel();
	scoreboard.setIcon(new ImageIcon("gradient.png"));
	scoreboard.setLayout(new GridLayout(0,2));
	JLabel col1 = new JLabel("Names"), col2 = new JLabel("Scores");
	table[0][0] = col1;
	table[0][1] = col2;
	
	col1.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	col2.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));


	col1.setFont(new Font("Times New Roman", Font.PLAIN, 60));
	col2.setFont(new Font("Times New Roman", Font.PLAIN, 60));
	scoreboard.add(col1);
	scoreboard.add(col2);


	//Add all names and score to arraylist
	try{
	    File f1 = new File("names.txt");
	    FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while ((line = br.readLine()) != null){
		names.add(line);
	    }
	    fr.close();
	    br.close();

	    File f2 = new File("scores.txt");
	    FileReader fr2 = new FileReader(f2);
	    BufferedReader br2 = new BufferedReader(fr2);
	    while ((line = br2.readLine()) != null){
		scores.add((Integer.parseInt(line)));
	    }
	}catch(Exception ee){
	}


	//Add all names and score from arraylist to table
	ArrayList<Integer> numsUsed = new ArrayList<Integer>();
	for (int i = 1; (i < 11) && (i < scores.size() + 1); i++){
	    int maxNum = -1;
	    for (int j = 0; j < scores.size(); j++){
		if (scores.get(j) > maxNum && numsUsed.indexOf(j) == -1){
		    maxNum = scores.get(j);
		    table[i][0] = new JLabel(names.get(j));
		    table[i][0].setFont(new Font("Times New Roman", Font.PLAIN, 40));
		    table[i][1] = new JLabel(scores.get(j) + "");
		    table[i][1].setFont(new Font("Times New Roman", Font.PLAIN, 40));
		    table[i][0].setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
		    table[i][1].setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
		}
	    }
	    numsUsed.add(names.indexOf(table[i][0].getText()));
	}
	

	
	
	for (int i = 1; i < 11; i++){
	    for (int j = 0; j < 2; j++){
		try{
		    scoreboard.add(table[i][j]);
		}catch(Exception e){
		}
	    }
	}
	scoreboard.setPreferredSize(new Dimension(700,700));

	
	name = new JTextField("Enter your name and press enter");
	name.addActionListener(this);

	pane.add(name);
	pane.add(scoreboard);

	this.pack();
	this.setVisible(true);



    }

    public void actionPerformed(ActionEvent e){
	if (name == e.getSource() && currentScore != -1){
	    String n = name.getText();
	    names.add(n);
	    name.setText("");
	    try{

		FileWriter fw = new FileWriter("names.txt", true);
		BufferedWriter out = new BufferedWriter(fw);
		out.newLine();
		out.append(n);
		out.flush();
		out.close();

		FileWriter fw2 = new FileWriter("scores.txt", true);
		BufferedWriter out2 = new BufferedWriter(fw2);
		out2.newLine();
		out2.append("" + currentScore);
		out2.flush();
		out2.close();


	    }catch(Exception ee){
	    }


	    
	    JLabel newName = new JLabel(n);
	    scoreboard.add(newName);
	    JLabel newScore = new JLabel(currentScore + "");
	    scoreboard.add(newScore);
	    currentScore = -1;

	    new HighScoreBoard();
	    this.dispose();
	}
    }

}
