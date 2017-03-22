import java.util.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.event.*; // trim for only click events. 

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;


  
// 15 spaces in game board


public class Cranium 
{
	public static String[] rollList = {"Purple","Yellow","Red","Blue","Green","Purple"};
	public static Scanner in = new Scanner(System.in);
	private static int numPlayers;
	private static int startingPlayer; 
	private static int diceRolls;
	private static boolean[] goneThisTurn; 
	private static JOptionPane game = new JOptionPane();
	
	public static void main( String[] args ) 
  {
  	setNumPlayers();
	initializeGoneThisTurn(numPlayers);
	startingPlayer = findFirstPlayer(numPlayers);
    JFrame f = new JFrame();

    JTextArea textArea = new JTextArea(  );
    f.add( new JScrollPane( textArea ), BorderLayout.CENTER );

    Timer timer = new Timer( 1000, new ActionListener() 
    {
      @Override
      public void actionPerformed( ActionEvent e ) 
      {
        textArea.append( "bla" );
      }
    } );
    timer.setRepeats( true );
    timer.start();
    JButton button = new JButton( "Click me" );
    button.addActionListener( e->{
        System.out.println("Before option pane");
        JOptionPane.showMessageDialog( f, "A message dialog" );
        System.out.println("After option pane");
    } );
    f.add( button, BorderLayout.SOUTH );
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.pack();
    f.setVisible( true );
  }
	public	 static void setNumPlayers()
	{// sets the number of players for the game. 
		int playerNum;
		playerNum = Integer.parseInt(JOptionPane.showInputDialog("How many players will there be? \n\n (between 2 - 4)"));
		if(playerNum < 2 || playerNum > 4 )
		{// handles the user entering the incorrect number of players.
			JOptionPane.showMessageDialog(null, "Invalid number of players selected", "alert", JOptionPane.ERROR_MESSAGE);
			setNumPlayers();
		}		
		numPlayers = playerNum;
	}
	
	public int getNumPlayers()
	{// gets the number of players for the game. 
		return numPlayers;
	}
	

	 private static void initializeGoneThisTurn(int numPlayers)
	 {//made to make the goneThisTurn Array to the size of the number of players
	 	goneThisTurn = new boolean[numPlayers];
	 	//will all be set to false as default. therefore not set explicitly.

	 }

	 private static void resetGoneThisTurn()
	 {// function to reset all the players status to reset the turn order in the main game loop
	 	for(boolean b : goneThisTurn)
	 	{
	 		b = false;
	 	}
	 }



	private static int findFirstPlayer(int numPlayers)
	{// returns the random number to choose the player that starts the game. 
		
		Random random = new Random();
		int randomNumber = random.nextInt()%numPlayers;
		return randomNumber;
	}
	
	private static int diceRoll()
	{// a random number generator to simulate dice rolls
		Random random = new Random();
		int roll = random.nextInt()%6;
		return roll -1; // to offset to find the position of the roll in the array. 
	}
	
}
