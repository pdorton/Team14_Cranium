import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by belmaz on 4/9/2017.
 */

public class Piece extends JFrame{

    public Piece(int color, int offset) {

        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {      //allows the user to drag the player around.

                Point point1 = MouseInfo.getPointerInfo().getLocation();
                setLocation(point1.x, point1.y);
            }
        });

        setMinimumSize(new Dimension(50,50));
        setLocation(650 + offset, 160); //set location of the piece. we set it on the start space of the board.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
        setUndecorated(true);

        switch(color){
            case 0:
                getContentPane().setBackground(Color.BLUE); // blue player
                break;
            case 1:
                getContentPane().setBackground(Color.RED); // red player
                break;
            case 2:
                getContentPane().setBackground(Color.GREEN);// green player
                break;
            case 3:
                getContentPane().setBackground(Color.YELLOW); //yellow player
                break;
        }

        setVisible(true);

    }
}
