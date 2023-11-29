import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;

public class TicTacFrame extends JFrame {
    // Images:
    final ImageIcon titleImg = new ImageIcon("resources/TicTacToe.png");
    // Colours:
    final Color NAVY_BLUE = new Color(0x2D3047); // Util. button colours
    final Color WHITE = new Color(0xFFFFFF); // Button Text, borders
    final Color BLUE = new Color(0x4A7AFF); // Tic Tac Toe buttons
    final Color PURPLE = new Color(0x7677FF); // Background

    // JPanels:
    JPanel ticTacToePanel;
    JPanel whiteBGPanel;
    JPanel titlePanel;
    JPanel buttonPanel;

    // JLabels:
    JLabel titleLabel;

    public TicTacFrame() {
// ---- Frame config: ----------------------------------------
        this.setTitle("Tic Tac Toe Toc!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setBackground(PURPLE);
        this.setIconImage(titleImg.getImage());
        this.setLayout(new BorderLayout());

// ---- ticTacToePanel config: -------------------------------
        ticTacToePanel = new JPanel();
        ticTacToePanel.setLayout(new GridLayout(4, 4, 10, 10));
        ticTacToePanel.setBackground(BLUE);

        // whiteBGPanel config:
        whiteBGPanel = new JPanel();
        whiteBGPanel.setLayout(null);
        whiteBGPanel.setBackground(WHITE);
        whiteBGPanel.setPreferredSize(new Dimension(370, 370));
        whiteBGPanel.add(ticTacToePanel);
        ticTacToePanel.setBounds(10, 10, 350, 350);

        // titleLabel config:
        titleLabel = new JLabel("Tic Tac Toe.. Toc?");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        // titlePanel config:
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(titleLabel);
        titlePanel.setBackground(PURPLE);

        // buttonPanel config:
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(PURPLE);


        // Adding Components:
        this.add(whiteBGPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

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
