import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class PiecePicker implements ActionListener
{
	private JFrame pieceFrame = new JFrame();
	private JPanel panel = new JPanel(new GridLayout(1,4));

	PiecePicker()
	{
		this.pieceFrame.setMinimumSize(new Dimension(800,400));
		this.pieceFrame.setMaximumSize(new Dimension(800,400));
		PickerButton red = new PickerButton("red");
		try 
		{
		  Image img = ImageIO.read(getClass().getResource("\\image_assets\\red_piece.png"));
		  red.setIcon(new ImageIcon(img));
		}
		catch (Exception ex) 
		{
		  System.out.println(ex);
		}
			 PickerButton yellow = new PickerButton("yellow");
		try {
		  Image img = ImageIO.read(getClass().getResource("\\image_assets\\yellow_piece.png"));
		  yellow.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		  System.out.println(ex);
		}
		PickerButton blue = new PickerButton("blue");
		try {
		  Image img = ImageIO.read(getClass().getResource("\\image_assets\\blue_piece.png"));
		  blue.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		  System.out.println(ex);
		}
		PickerButton green = new PickerButton("green");
		try {
		  Image img = ImageIO.read(getClass().getResource("\\image_assets\\green_piece.png"));
		  green.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		  System.out.println(ex);
		}
		red.addActionListener(this);
		yellow.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		this.panel.add(red);
		this.panel.add(yellow);
		this.panel.add(blue);
		this.panel.add(green);
		this.pieceFrame.add(panel);
		
		this.pieceFrame.setVisible(true);			
	}

	public void actionPerformed(ActionEvent actionEvent) 
    	{
        	if("red".equals(actionEvent.getActionCommand()))
        	{
        		System.out.println("pressed the red button");
        	}
      	}

	
}