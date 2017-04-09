import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardModified { 
	private static final String IMG_PREFIX = "res/images/";
	
	private int color; // 1=blue, 2=yellow, 3=red, 4=green
	private String imageLocation;
	private JFrame window;
	private boolean used = false;
	
	/*
	 * Every image will start with the prefix res/images/
	 * location changed to filename
	 * */
	public CardModified(String filename, int color) {
		this.color = color;
		this.imageLocation = new String(IMG_PREFIX + filename);
	}

	public int getColor() {
		return this.color;
	}

	public boolean hasBeenUsed() {
		return this.used;
	}

	public void showCardModified() {
		this.window = new JFrame();

		
		this.window.setLayout(null);
		this.window.setSize(280, 420);
		this.window.setLocationRelativeTo(null);
		this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.window.setResizable(false);
		
		ImageIcon image = new ImageIcon(this.imageLocation);
		JLabel imageLabel = new JLabel(image);
		JButton correct = new JButton("Right!");
		JButton incorrect = new JButton("Wrong.");
		imageLabel.setBounds(0, 0, 280, 300);
		correct.setBounds(30, 300, 90, 40);
		incorrect.setBounds(150, 300, 90, 40);
		correct.setBackground(Color.green);
		incorrect.setBackground(Color.red);

		correct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	// ------------------------------------------------------------------------

	// This main function is just to show how the "deck" should be implemented
	// inside Cranium.java and not necessarily inside of the CardModified class

	// Comment this whole main out if you want to test and run my modified CardModified
	// class
	public static void main(String[] args) {
		CardModified[] deck = new CardModified[14];
		// Blue CardModifieds
		deck[0] = new CardModified("blue_cloodle_1.jpg", 1);
		deck[1] = new CardModified("blue_cloodle_2.jpg", 1);
		deck[2] = new CardModified("blue_sensosketch_1.jpg", 2);

		// Yellow CardModifieds
		deck[3] = new CardModified("yellow_blankout_1.jpg", 2);
		deck[4] = new CardModified("yellow_gnilleps_1.jpg", 2);
		deck[5] = new CardModified("yellow_lexicon_1.jpg", 2);
		deck[6] = new CardModified("yellow_spellbound_1.jpg", 2);
		deck[7] = new CardModified("yellow_zelpuz_1.jpg", 2);

		// Red CardModifieds
		deck[8] = new CardModified("red_factoid_1.jpg", 3);
		deck[9] = new CardModified("red_polygraph_1.jpg", 3);
		deck[10] = new CardModified("red_selectaquest_1.jpg", 3);

		// Green CardModifieds
		deck[11] = new CardModified("green_cameo_1.jpg", 4);
		deck[12] = new CardModified("green_copycat_1.jpg", 4);
		deck[13] = new CardModified("green_humdinger_1.jpg", 4);

		// Testing to see how all CardModifieds look on scren at once and closing
		// feauture
		for (int i = 0; i < deck.length; i++)
			deck[i].showCardModified();
	}
}