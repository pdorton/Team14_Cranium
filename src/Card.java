<<<<<<< HEAD:src/Card.java
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.io.*;


public class Card 
{
	private int color;
	/*
		1 = blue
		2 = yellow
		3 = red
		4 = green
	*/
	private JFrame window; 
	private boolean used = false;
	public Card(String imageLocation, int color)
	{
		this.color = color;
		 try 
		 { // attempt to make the board have the picture of the background from the file given
            this.window.add(new JLabel(new ImageIcon(ImageIO.read(new File(imageLocation)))), BorderLayout.CENTER);
         } 
         catch (IOException e) 
         {// if file not found
            e.printStackTrace();
         }
	}
	public Card[] makeDeck()
	{// makes an array of Card objects that will represent the different cards
	// this will be hardcoded and then return a Deck of "Cards" 
		
		return null;
	}
	
	public void displayCard(Card[] deck,int color)
	{/* function to display a jframe that the user will have pop up over the game board screen to show
		the card that the user is trying to guess correctly */
		int position = 0;
		boolean found = false;
		while(!found)
		{// while a card of the correct color has not been found, iterate through and search for a certian color
				if(deck[position].getColor() == color) 
				{// if the color of the card at the given position is of the needed color then display it 
					// display the JFrame for the card. 
					this.window.show();//Debug: not been compiled yet
					
				}
				else
				{// if the card at that position is the wrong color
					
					if(position + 1 <= deck.length)
					{// if there are more cards left
						position++; // move to the next card
					}
					else
					{// return to the first card in the deck.
						position = 0;
					}
				}
		}
	}
	
	public int getColor()
	{//Debug: needs testing to know if this function will work or not. 
		return this.color;	
	}
	
	
	
=======
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.io.IOException;
public class Card 
{
	 private int color;                   // 1=blue, 2=yellow, 3=red, 4=green
    private String imageLocation;
    public JFrame window; 
    private boolean used = false;
    
    public Card(String location, int color)
    {
        this.color = color;
        this.imageLocation = location;	
    }
    
    public int getColor()
    {
        return this.color;
    }
    
    public boolean hasBeenUsed()
    {
        return this.used;
    }
        
    public void showCard()
    {
        this.window = new JFrame();
        this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.window.setSize(310, 420);
        this.window.setResizable(false);
        
        ImageIcon image = new ImageIcon(this.imageLocation);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.imageLocation)));
        this.window.add(imageLabel);
        this.window.setVisible(true);
    }
    public void setUsed(boolean used)
    {
    	this.used = used;
    }
}
>>>>>>> refs/remotes/origin/master:Card.java
	
	
	
	

