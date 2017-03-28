
public class Card 
{
	private int color;
	private String text;
	private String hint;
	private String correctAnswer;
	private String[] answers = new String[4];
	private JFrame window; 
	
	public Card[] makeDeck()
	{// makes an array of JFrames that will represent the diffent cards
	// this will be hardcoded and then return a Deck of "Cards" 
		
		
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
					
					if(position + 1 <= deck.length())
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
	
	
	
	
	
	
	
}
