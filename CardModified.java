import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.io.IOException;

public class CardModified 
{
    private int color;                   // 1=blue, 2=yellow, 3=red, 4=green
    private String imageLocation;
    private JFrame window; 
    private boolean used = false;
    
    public CardModified(String location, int color)
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
        
        this.window.setSize(280, 420);
        this.window.setResizable(false);
        
        ImageIcon image = new ImageIcon(this.imageLocation);
        JLabel imageLabel = new JLabel(image);
        this.window.add(imageLabel);
        this.window.setVisible(true);
    }
}


// ------------------------------------------------------------------------


// This main function is just to show how the "deck" should be implemented
// inside Cranium.java and not necessarily inside of the Card class

// Comment this whole main out if you want to test and run my modified Card class
public static void main(String[] args)
{           
    Card[] deck = new Card[14];
        
    // Blue Cards
    deck[0] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\blue_cloodle_1.jpg", 1);
    deck[1] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\blue_cloodle_2.jpg", 1);
    deck[2] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\blue_sensosketch_1.jpg", 2);
        
    // Yellow Cards
    deck[3] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\yellow_blankout_1.jpg", 2);
    deck[4] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\yellow_gnilleps_1.jpg", 2);
    deck[5] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\yellow_lexicon_1.jpg", 2);
    deck[6] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\yellow_spellbound_1.jpg", 2);
    deck[7] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\yellow_zelpuz_1.jpg", 2);
        
    // Red Cards
    deck[8] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\red_factoid_1.jpg", 3);
    deck[9] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\red_polygraph_1.jpg", 3);
    deck[10] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\red_selectaquest_1.jpg", 3);
        
    // Green Cards
    deck[11] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\green_cameo_1.jpg", 4);
    deck[12] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\green_copycat_1.jpg", 4);
    deck[13] = new Card("C:\\Users\\Joan\\Desktop\\Card Images\\green_humdinger_1.jpg", 4);     
        
    // Testing to see how all cards look on scren at once and closing feauture
    for(int i=0; i<deck.length; i++)
        deck[i].showCard();
}
