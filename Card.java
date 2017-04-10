import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Card 
{
	 private int color;                   // 1=blue, 2=yellow, 3=red, 4=green
    private String imageLocation;
    public JFrame window; 
    public boolean used = false;
    
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
        this.window.setLayout(null);
        this.window.setSize(280, 460);
        this.window.setLocationRelativeTo(null);
        this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.window.setResizable(false);

        ImageIcon image = new ImageIcon(this.imageLocation);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.imageLocation)));

        JButton correct = new JButton("Right!");
        JButton incorrect = new JButton("Wrong.");
        imageLabel.setBounds(0, 0, 280, 380);
        correct.setBounds(30, 380, 90, 40);
        incorrect.setBounds(150, 380, 90, 40);
        correct.setBackground(Color.green);
        incorrect.setBackground(Color.red);

        correct.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(" current player is = " + Cranium.getCurrentPlayer());
                    Cranium.updateScore(Cranium.getCurrentPlayer());
                    Cranium.nextPlayer();
                    window.dispose();
                }
            });

        incorrect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cranium.nextPlayer();
                window.dispose();
            }
        });

        this.window.add(imageLabel);
        this.window.add(correct);
        this.window.add(incorrect);

        this.window.setVisible(true);
    }
    public void setUsed(boolean used)
    {
    	this.used = used;
    }
}
	
	
	
	

