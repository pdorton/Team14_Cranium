// Kyle Turner
// Group 14
// ==============
// Emulates a paint function

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// Basic paint tool. Has colors, eraser, and clear.
public class Paint extends JApplet{

	//
	public static class PaintPanel extends JPanel implements MouseListener, MouseMotionListener{

		private final static int
		BLACK = 0,
		RED = 1,     
		GREEN = 2,   
		BLUE = 3, 
		PINK = 4,   
		YELLOW = 5,
		WHITE = 6;

		private int currentColor = BLACK;
		private int prevX, prevY;

		private boolean dragging;
		private Graphics graphicsForDrawing;

		//
		PaintPanel(){
			setBackground(Color.WHITE);
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		// 
		public void paintComponent(Graphics g){

			// Make the paint component white
			super.paintComponent(g);

			int width = getWidth();
			int height = getHeight();

			int colorSpacing = (height - 56) / 7;

			// Make the background of the window gray
			g.setColor(Color.GRAY);
			g.drawRect(0, 0, width-1, height-1);
			g.drawRect(1, 1, width-3, height-3);
			g.drawRect(2, 2, width-5, height-5);

			g.fillRect(width - 56, 0, 56, height);

			g.setColor(Color.WHITE);
			g.fillRect(width-53,  height-53, 50, 50);
			g.setColor(Color.BLACK);
			g.drawRect(width-53, height-53, 49, 49);
			g.drawString("CLEAR", width-48, height-23); 

			
			// Create the palette of colors.
			g.setColor(Color.BLACK);
			g.fillRect(width-53, 3 + 0*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.RED);
			g.fillRect(width-53, 3 + 1*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.GREEN);
			g.fillRect(width-53, 3 + 2*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.BLUE);
			g.fillRect(width-53, 3 + 3*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.PINK);
			g.fillRect(width-53, 3 + 4*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.YELLOW);
			g.fillRect(width-53, 3 + 5*colorSpacing, 50, colorSpacing-3);
			g.setColor(Color.WHITE);
			g.fillRect(width-53, 3 + 6*colorSpacing, 50, colorSpacing-3);

			g.setColor(Color.WHITE);
			g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
			g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
		}

		// Create the visual effect that the color selected is wrapped in white.
		private void changeColor(int y){

			int width = getWidth();
			int height = getHeight();
			int colorSpacing = (height - 56) / 7;
			int newColor = y / colorSpacing;

			if (newColor < 0 || newColor > 6)
				return;

			// Colors not selected are wrapped in gray.
			Graphics g = getGraphics();
			g.setColor(Color.GRAY);
			g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
			g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
			currentColor = newColor;
			
			// The color selected is wrapped in white.
			g.setColor(Color.WHITE);
			g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
			g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
			g.dispose();
		}

		// Selects the new color from currentColor
		private void setUpDrawingGraphics(){
			
			graphicsForDrawing = getGraphics();
			switch (currentColor){
			case BLACK:
				graphicsForDrawing.setColor(Color.BLACK);
				break;
			case RED:
				graphicsForDrawing.setColor(Color.RED);
				break;
			case GREEN:
				graphicsForDrawing.setColor(Color.GREEN);
				break;
			case BLUE:
				graphicsForDrawing.setColor(Color.BLUE);
				break;
			case PINK:
				graphicsForDrawing.setColor(Color.PINK);
				break;
			case YELLOW:
				graphicsForDrawing.setColor(Color.YELLOW);
				break;
			case WHITE:
				graphicsForDrawing.setColor(Color.WHITE);
				break;
			}
		}

		// Action for pressing on the mouse button.
		public void mousePressed(MouseEvent event){

			// Get x,y of where user clicked
			int x = event.getX();
			int y = event.getY();

			int width = getWidth();
			int height = getHeight();

			// Ignore if the user is holding the mouse button
			if (dragging == true)
				return;

			if (x > width - 53){
				// Clicked the clear button.
				if (y > height - 53)
					repaint();
				// Clicked to change the color.
				else
					changeColor(y);
			}
			// User clicked white space. Start drawing.
			else if (x > 3 && x < width - 56 && y > 3 && y < height - 3){
				prevX = x;
				prevY = y;
				dragging = true;
				setUpDrawingGraphics();
			}

		}

		// Action for releasing the mouse button. Stops creating the segment of the drawing.
		public void mouseReleased(MouseEvent event){

			if (!dragging)
				return;
			dragging = false;
			graphicsForDrawing.dispose();
			graphicsForDrawing = null;
		}

		// Action for dragging the mouse. Makes a drawing.
		public void mouseDragged(MouseEvent event){

			// Nothing to do if user is not drawing.
			if (!dragging)
				return;

			// Get x,y of the mouse
			int x = event.getX();	
			int y = event.getY();

			// Adjust x,y of the mouse so it's in the drawing area.
			if (x < 3)
				x = 3;
			if (x > getWidth() - 57)
				x = getWidth() - 57;

			if (y < 3)
				y = 3;
			if (y > getHeight() - 4)
				y = getHeight() - 4;

			// Draw the line.
			graphicsForDrawing.drawLine(prevX, prevY, x, y);

			// Prep for next line segment.
			prevX = x;
			prevY = y;

		}

		// Empty methods required by MouseListener and MouseMotionListener.
		public void mouseEntered(MouseEvent event){ }
		public void mouseExited(MouseEvent event){ }
		public void mouseClicked(MouseEvent event){ }
		public void mouseMoved(MouseEvent event){ }     
	}

	// Makes a new paint window.
	public static void paint(){
		JFrame window = new JFrame("Paint");
		PaintPanel content = new PaintPanel();
		window.setContentPane(content);
		window.setSize(480, 270);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
	}



	public void init(){
		setContentPane(new PaintPanel());
	}

}