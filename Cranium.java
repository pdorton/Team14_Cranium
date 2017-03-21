import java.util.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.event.*; // trim for only click events. 









// 15 spaces in game board


public class Cranium 
{
	public static String[] rollList = {"Purple","Yellow","Red","Blue","Green","Purple"};
	public static Scanner in = new Scanner(System.in);
	private static int numPlayers;
	private static int startingPlayer; 
	private static int diceRolls;
	private static JOptionPane game = new JOptionPane();
	
	
	
	public static void main(String[] args) 
	{
		setNumPlayers();
		startingPlayer = getRandomNumber(numPlayers);
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
	
	private static int getRandomNumber(int numPlayers)
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
