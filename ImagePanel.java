import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel
{
    // ended up re-doing the original cranium.java
    private Image image = null;
    public static String[] rollList = {"Purple","Yellow","Red","Blue","Green","Purple"};
    public static Scanner in = new Scanner(System.in);
    private static int numPlayers;
    private static int startingPlayer;
    private static int currentPlayer;
    private static int diceRolls;
    private static boolean[] goneThisTurn;
    private static JOptionPane game = new JOptionPane();
    JFrame board = new JFrame();
    private static int p1Score;
    private static int p2Score;
    private static int p3Score;
    private static int p4Score;
    private static Font scoreFont = new Font(Font.SANS_SERIF, 3, 16); // font to display the score properly at the top of the board
    private static Font timerFont = new Font(Font.SANS_SERIF, 3, 16); // font to display the score properly at the top of the board

    public ImagePanel(String filename) {
        this.image = new ImageIcon(filename).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }

    public static void setNumPlayers()
    {// sets the number of players for the game.
        int playerNum;
        playerNum = Integer.parseInt(JOptionPane.showInputDialog("How many players will there be? \n\n (between 2 - 4)"));
        if(playerNum < 2 || playerNum > 4 )
        {// handles the user entering the incorrect number of players.
            JOptionPane.showMessageDialog(null, "Invalid number of players selected", "alert", JOptionPane.ERROR_MESSAGE);
            setNumPlayers();
        }
        numPlayers = playerNum;
    }
    public int getNumPlayers()
    {// gets the number of players for the game.
        return numPlayers;
    }

    private static void initializeGoneThisTurn(int numPlayers)
    {//made to make the goneThisTurn Array to the size of the number of players
        goneThisTurn = new boolean[numPlayers];
        //will all be set to false as default. therefore not set explicitly.

    }
    private static void initScores()
    {// initializes all scores to 0
        p1Score = 0;
        p2Score = 0;
        p3Score = 0;
        p4Score = 0;
    }

    private static String getScores(int numPlayers)
    {// function to create and zero out the score keeping ui for the game.
        //will be dependent on the number of player that will be playing to only display the score for the number playing.

        //as games will have a min of two player we will always initialize the first two

		/*code for implementing the first two goes here*/
        String scoreString;
        switch(numPlayers)
        {
            case(2): // if two players
                scoreString = "\t\t\t\t\tPlayer 1: " + p1Score + "\t\t\tPlayer 2: " + p2Score;
                break;

            case(3): // if three players
                scoreString = "\t\t\t\tPlayer 1: " + p1Score + "\t\tPlayer 2: " + p2Score + "\t\tPlayer 3: " + p3Score;
                break;


            default://technically 4 is included here
                scoreString = "\t\t\tPlayer 1: " + p1Score + "\t\tPlayer 2: " + p2Score + "\t\tPlayer 3: " + p3Score + "\t\tPlayer 4: " + p4Score;
                break;

        }

        return scoreString;
    }

    private void updateScore(int player)
    {
        switch(player)
        {
            case(1):
                //System.out.println("incrementing player 1");
                p1Score++;
                break;
            case(2):
                //System.out.println("incrementing player 2");
                p2Score++;
                break;
            case(3):
                //System.out.println("incrementing player 3");
                p3Score++;
                break;
            case(4):
                //System.out.println("incrementing player 4");
                p4Score++;
                break;
            default://if not one of the players then do nothing
                //System.out.println(player  + " is not a valid player #");
                break;
        }
    }
}