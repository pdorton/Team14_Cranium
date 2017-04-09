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
	
	
	
	

