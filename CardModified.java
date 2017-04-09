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
    
    // Testing to see how all cards look on scren at once and closing feauture
    for(int i=0; i<deck.length; i++)
        deck[i].showCard();
}
