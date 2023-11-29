import javax.swing.*;
import java.awt.*;

public class TicTacFrame extends JFrame {
    final ImageIcon titleImg = new ImageIcon("resources/TicTacToe.png");
    // Colours
    final Color NAVY_BLUE = new Color(0x2D3047); // Util. button colours
    final Color WHITE = new Color(0xFFFFFF); // Button Text, borders
    final Color BLUE = new Color(0x4A7AFF); // Tic Tac Toe buttons
    final Color PURPLE = new Color(0x7677FF); // Background
    public TicTacFrame() {
        // Frame config:
        super("Tic-Tac-Toe-Toc"); // Calls JFrame constructor, passing in the title.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        getContentPane().setBackground(PURPLE);
        setIconImage(titleImg.getImage());

//      pack(); // Resizes JFrame to perfectly include all components.
        setLocationRelativeTo(null); // Centres the JFrame.
//      setResizable(false);
        setVisible(true);
    }
}
/*

Plan:
    - JFrame:
        - Border layout manager.
        - Background colour: PURPLE.
    - Centre JPanel (whiteBGPanel):
        - null layout manager.
        - Background colour: WHITE
        - 370px x 370px size.
        - Add another JPanel (containing tic-tac-toe buttons) to (x,y) coordinates of (10, 10).
            - Tic-Tac-Toe Panel (ticTacToePanel):
                - Grid layout manager - 4x4 grid, one cell for each button
                    - Background colour: BLUE
                    - 10px margins both horizontally and vertically.
                    - GridLayout ticTacToeButtonLayout = new GridLayout(4, 4, 10, 10)
                - 350px x 350px size.
                - Background colour: WHITE
    - North JPanel (titlePanel):
        - Flow layout manager, default setting: centred.
        - 410px x 30px.
        - Label: "Tic-Tac-Toe-Toc!"
    - East/West JPanel (eastPanel, westPanel):
        - Respective alignment
        - Serves as spacing. Nothing contained within.
    - South JPanel (buttonPanel):
        - Flow layout manager, default setting: centred.
        - 3 Buttons: Play, Reset Board, Show Wins
            - On button press, when not playing: popup appears, stating "Please press play."
            - Show wins should be a popup.

Optional:
    - JMenuBar: One tab, called game, which has 3 buttons: play, reset board, show wins.




 */
