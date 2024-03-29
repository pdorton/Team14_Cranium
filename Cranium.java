
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

public class Cranium {

    public static String[] rollList = {"Purple", "Yellow", "Red", "Blue", "Green", "Purple"};
    public static Scanner in = new Scanner(System.in);
    private static int numPlayers;
    private static int startingPlayer;
    public static int currentPlayer;
    private static int diceRolls;
    private static boolean[] goneThisTurn;
    private static int playerPiece[];
    private static JOptionPane game = new JOptionPane();
    private JFrame board = new JFrame();
    public static int p1Score;
    public static int p2Score;
    public static int p3Score;
    public static int p4Score;
    public Font scoreFont = new Font(Font.SANS_SERIF, 3, 16); // font to display the score properly at the top of the board
    public static Font timerFont = new Font(Font.SANS_SERIF, 3, 16); // font to display the score properly at the top of the board
    public static String scores;
    public static JTextArea scoreTextArea;

    Cranium() {//constructor for new Cranium game
        scoreTextArea = new JTextArea(1, 100); // makes a text area of 1 row and a max of 100 characters to display the score 

        setNumPlayers();//calls a pop up to request the number of player from the user
        playerPiece = new int[numPlayers];
        initializeGoneThisTurn(numPlayers); // sets who has gone this turn to all false
        currentPlayer = findFirstPlayer(numPlayers); // determins the player who will be going first
        initScores(); // set all scores to 0 
        this.board.setMinimumSize(new Dimension(1500, 1500)); // makes sure the window is no smaller than 1500x1500
        this.board.setMaximumSize(new Dimension(1500, 1500)); // makes sure the window is no larger than 1500x1500
        scoreTextArea.setFont(scoreFont); // sets the font of the score's text to be a specific font for readablity
        this.board.add(scoreTextArea, BorderLayout.NORTH); // adds the score to the top part of the window 
        scores = getScores(numPlayers);
        scoreTextArea.setText(scores);

        // attempt to make the board have the picture of the background from the file given
        ImageIcon image = new ImageIcon("board_background_image.jpg");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("board_background_image.jpg")));

        this.board.add(imageLabel, BorderLayout.CENTER);
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.pack();
        this.board.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException 
    {
        int rand = diceRoll();
        Cranium game = new Cranium(); // creates a new Cranium Game
        new Dice().setVisible(true);
        Paint.paint();
        Card[] deck = makeDeck();

        for (int j = 0; j < numPlayers; j++) {
            Piece player = new Piece(j, j * 10);
        }
        for (int i = 0; i < deck.length; i++) {
            displayCard(deck, deck[i].getColor());
            Thread.sleep(20000);
        }

    }

    // sets the number of players for the game.
    public static void setNumPlayers() 
    { 
        int playerNum;
        playerNum = Integer.parseInt(JOptionPane.showInputDialog("How many players will there be? \n\n (between 2 - 4)"));
        if (playerNum < 2 || playerNum > 4) {// handles the user entering the incorrect number of players.
            JOptionPane.showMessageDialog(null, "Invalid number of players selected", "alert", JOptionPane.ERROR_MESSAGE);
            setNumPlayers();
        }
        numPlayers = playerNum;
    }

    // gets the number of players for the game. 
    public int getNumPlayers() 
    {
        return numPlayers;
    }

    //made to make the goneThisTurn Array to the size of the number of players
    private static void initializeGoneThisTurn(int numPlayers) 
    {
        goneThisTurn = new boolean[numPlayers];
        //will all be set to false as default. therefore not set explicitly.
    }

    // function to reset all the players status to reset the turn order in the main game loop
    private static void resetGoneThisTurn() 
    {
        for (boolean b : goneThisTurn) {
            b = false;
        }
    }

    // returns the random number to choose the player that starts the game.
    private static int findFirstPlayer(int numPlayers) 
    {
        Random random = new Random();
        int randomNumber = (int) random.nextInt() % numPlayers;
        return randomNumber + 1;
    }

    // a random number generator to simulate dice rolls
    private static int diceRoll() 
    {
        Random random = new Random();
        int roll = (int) random.nextInt() % 3;
        return roll + 1; // to offset to find the position of the roll in the array. 
    }

    public static String getScores(int numPlayers) 
    {// function to create and zero out the score keeping ui for the game.
        //will be dependent on the number of player that will be playing to only display the score for the number playing. 

        //as games will have a min of two player we will always initialize the first two

        /*code for implementing the first two goes here*/
        String scoreString;
        switch (numPlayers) {
            case (2): // if two players 
                scoreString = "\t\t\t\t\tPlayer 1: " + p1Score + "\t\t\tPlayer 2: " + p2Score;
                break;

            case (3): // if three players
                scoreString = "\t\t\t\tPlayer 1: " + p1Score + "\t\tPlayer 2: " + p2Score + "\t\tPlayer 3: " + p3Score;
                break;

            default://technically 4 is included here 
                scoreString = "\t\t\tPlayer 1: " + p1Score + "\t\tPlayer 2: " + p2Score + "\t\tPlayer 3: " + p3Score + "\t\tPlayer 4: " + p4Score;
                break;

        }

        return scoreString;

    }

    public static void updateScore(int player) 
    {
        switch (player) {
            case (1):
                //System.out.println("incrementing player 1");
                p1Score++;
                scores = getScores(numPlayers);
                scoreTextArea.setText(scores);
                break;
            case (2):
                //System.out.println("incrementing player 2");
                p2Score++;
                scores = getScores(numPlayers);
                scoreTextArea.setText(scores);
                break;
            case (3):
                //System.out.println("incrementing player 3");
                p3Score++;
                scores = getScores(numPlayers);
                scoreTextArea.setText(scores);
                break;
            case (4):
                //System.out.println("incrementing player 4");
                p4Score++;
                scores = getScores(numPlayers);
                scoreTextArea.setText(scores);
                break;
            default://if not one of the players then do nothing
                //System.out.println(player  + " is not a valid player #");
                break;
        }
    }

    // initializes all scores to 0
    private void initScores() 
    {
        p1Score = 0;
        p2Score = 0;
        p3Score = 0;
        p4Score = 0;
    }

    private static void startTimer(JFrame window) 
    {
        JTextArea timerTextArea = new JTextArea(1, 2);
        timerTextArea.setFont(timerFont);
        window.add(timerTextArea, BorderLayout.WEST);
        /*following code makes a timer and closes a window after some amount of time, will be 60 in the end, 10 for testing purposes */
        Timer timer = new Timer(1000, new ActionListener() {

            int countdown = 20;

            @Override
            public void actionPerformed(ActionEvent e) {

                String timeLeft;
                if (countdown == 0) {// testing timer ending, Debug: remove this later
                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                }

                timeLeft = Integer.toString(countdown);
                timerTextArea.setText(timeLeft);

                countdown--;

            }
        }); // end of timer creation Debug: needs to be moved to a function to abstract this for each turn
        timer.start(); // starts the timer
    }

    public static Card[] makeDeck() 
    {
        Card[] deck = new Card[14];

        // Blue Cards
        deck[0] = new Card("blue_cloodle_1.jpg", 1);
        deck[1] = new Card("blue_cloodle_2.jpg", 1);
        deck[2] = new Card("blue_sensosketch_1.jpg", 1);

        // Yellow Cards
        deck[3] = new Card("yellow_blankout_1.jpg", 2);
        deck[4] = new Card("yellow_gnilleps_1.jpg", 2);
        deck[5] = new Card("yellow_lexicon_1.jpg", 2);
        deck[6] = new Card("yellow_spellbound_1.jpg", 2);
        deck[7] = new Card("yellow_zelpuz_1.jpg", 2);

        // Red Cards
        deck[8] = new Card("red_factoid_1.jpg", 3);
        deck[9] = new Card("red_polygraph_1.jpg", 3);
        deck[10] = new Card("red_selectaquest_1.jpg", 3);

        // Green Cards
        deck[11] = new Card("green_cameo_1.jpg", 4);
        deck[12] = new Card("green_copycat_1.jpg", 4);
        deck[13] = new Card("green_humdinger_1.jpg", 4);

        return deck;
    }

    public static int getCurrentPlayer() 
    {
        return currentPlayer;
    }

    public static void nextPlayer() 
    {
        currentPlayer = currentPlayer == numPlayers ? 1 : currentPlayer + 1;
    }

    /* function to display a jframe that the user will have pop up over the game board screen to show
    the card that the user is trying to guess correctly */
    public static void displayCard(Card[] deck, int color) 
    {
        int position = 0;
        boolean found = false;
        System.out.println("color = " + color);
        while (!found) {// while a card of the correct color has not been found, iterate through and search for a certian color
            if (deck[position].getColor() == color && deck[position].used == false) {// if the color of the card at the given position is of the needed color then display it 
                // display the JFrame for the card. 
                deck[position].showCard();//Debug: not been compiled yet
                found = true;
                deck[position].setUsed(true);
                startTimer(deck[position].window);

            } else {// if the card at that position is the wrong color

                if (position + 1 < deck.length) {// if there are more cards left
                    position++; // move to the next card
                } else {// return to the first card in the deck.
                    position = 0;
                }
            }
        }
    }

}
