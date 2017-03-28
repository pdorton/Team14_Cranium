import java.util.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.event.*; // trim for only click events. 
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
  
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
	JFrame board = new JFrame();
	private int p1Score;
	private int p2Score;
	private int p3Score;
	private int p4Score;
	private Font scoreFont = new Font(Font.SANS_SERIF, 3, 25); // font to display the score properly at the top of the board




	Cranium()
	{//constructor for new Cranium game
		setNumPlayers();
		initializeGoneThisTurn(numPlayers);
		startingPlayer = findFirstPlayer(numPlayers);
		initScores();
		this.board.setMinimumSize(new Dimension(1500,1500));
		this.board.setMaximumSize(new Dimension(1500,1500));
		JTextArea scoreTextArea = new JTextArea(1,100);
		scoreTextArea.setFont(scoreFont);
		this.board.add(scoreTextArea, BorderLayout.NORTH );
		 try {
            this.board.add(new JLabel(new ImageIcon(ImageIO.read(new File("board_background_image.jpg")))), BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
		Timer timer = new Timer( 1000, new ActionListener() 
		{
			
		 int countdown = 10;
		  @Override
		  public void actionPerformed( ActionEvent e ) 
		  {
		  	
			String timerString;
		  	if(countdown == 0)
		  	{// testing timer ending, Debug: remove this later
		  		board.dispatchEvent(new WindowEvent(board, WindowEvent.WINDOW_CLOSING));
		  	}
		  	timerString = "\t\t\tPlayer 1: " + p1Score + "\t\tPlayer 2: " + p2Score + "\t\tPlayer 3: " + p3Score + "\t\tPlayer 4: " + p4Score;
		    scoreTextArea.setText( timerString  );
		    countdown--;

		
		  } 
		} );
		timer.start();
		this.board.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.board.pack();
		this.board.setVisible( true );
	}
	


	public static void main( String[] args ) 
  {
    Cranium game = new Cranium();
    
  }
	public static void setNumPlayers()
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


	private static void initializeScoreKeeper(int numPlayers)
	{// function to create and zero out the score keeping ui for the game.
		//will be dependent on the number of player that will be playing to only display the score for the number playing. 

		//as games will have a min of two player we will always initialize the first two

		/*code for implementing the first two goes here*/

		switch(numPlayers)
		{
			case(2): // if two players 

				break;

			case(3): // if three players

				break;


			default://technically 4 is included here 

				 break;

		}

	}

	private void updateScore(int player)
	{
		switch(player)
		{
			case(1):
				p1Score++;
				break;
			case(2):
				p2Score++;
				break;
			case(3):
				p3Score++;
				break;
			case(4):
				p4Score++;
				break;
			default://if not one of the players then do nothing
				break;
		}
	}

	private void initScores()
	{// initializes all scores to 0
		p1Score = 0;
		p2Score = 0;
		p3Score = 0;
		p4Score = 0;
	}



	
}
