import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class TicTacFrame extends JFrame {
    // Images:
    final ImageIcon titleImg = new ImageIcon("resources/TicTacToe.png");
    // Colours:
    final Color NAVY_BLUE = new Color(0x21284F); // Util. button colours
    final Color WHITE = new Color(0xFFFFFF); // Button Text, borders, tic-tac-toe buttons.
    final Color BLUE = new Color(0x6791FF); // Background
    final Color BLACK = new Color(0x3D539B); // Tic Tac Toe Lines

    // JPanels:
    JPanel ticTacPanel;
    JPanel titlePanel;
    JPanel buttonPanel;
    JPanel eastPanel, westPanel; // To provide buffer spacing for the centre panel.

    // JLabels:
    JLabel titleLabel;

    // JButtons:
    JButton playBTN;
    JButton resetBoardBTN;
    JButton showWinsBTN;
    JButton[] ticTacBTNS = new JButton[16];
    /*
    [] [] [] []
    [] [] [] []
    [] [] [] []
    [] [] [] []
     */

    public TicTacFrame() {
// ---- Frame config: ----------------------------------------
        this.setTitle("Tic Tac Toe.. Toc?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(660, 660);
        this.getContentPane().setBackground(WHITE);
        this.setIconImage(titleImg.getImage());
        this.setLayout(new BorderLayout());

// ---- ticTacPanel config: -------------------------------
        ticTacPanel = new JPanel();
        ticTacPanel.setPreferredSize(new Dimension(525, 525));
        ticTacPanel.setLayout(new GridLayout(4, 4, 15, 15));
        ticTacPanel.setBackground(BLACK);
        for(int i = 0; i < 16; i++) {
            ticTacBTNS[i] = new JButton();
            ticTacBTNS[i].setBackground(WHITE);
            ticTacBTNS[i].setFocusable(false);
            ticTacBTNS[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            ticTacBTNS[i].setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
            ticTacBTNS[i].setText("Press \nPlay!");
            ticTacBTNS[i].addActionListener(new TicTacBTNListener(this));
            ticTacPanel.add(ticTacBTNS[i]);
        }

// ---- titleLabel config: ------------------------------------
        titleLabel = new JLabel("Tic Tac Toe... Toc?");
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
        titleLabel.setForeground(WHITE);
        titleLabel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(), // Border style
                "Introducing...", // Title
                TitledBorder.LEFT, // Horizontal positioning of the text.
                TitledBorder.BELOW_TOP, // Vertical positioning of the text.
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12), // Font style
                WHITE // Text colour.
        ));

// ---- titlePanel config: ------------------------------------
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(titleLabel);
        titlePanel.setBackground(BLUE);
        titlePanel.setPreferredSize(new Dimension(750, 0));

// ---- eastPanel & westPanel config: -------------------------
        eastPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel.setBackground(BLUE);
        westPanel.setBackground(BLUE);
        eastPanel.setPreferredSize(new Dimension(68, 750));
        westPanel.setPreferredSize(new Dimension(68, 750));

// ---- playBTN config: ---------------------------------------
        playBTN = new JButton("Play");
        playBTN.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        playBTN.setFocusable(false);
        playBTN.setBackground(NAVY_BLUE);
        playBTN.setForeground(WHITE);
        playBTN.addActionListener(new PlayBTNListener(this));

// ---- resetBoardBTN config: ---------------------------------
        resetBoardBTN = new JButton("Reset Board");
        resetBoardBTN.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        resetBoardBTN.setFocusable(false);
        resetBoardBTN.setBackground(NAVY_BLUE);
        resetBoardBTN.setForeground(WHITE);
        resetBoardBTN.addActionListener(new ResetBoardBTNListener(this));

// ---- showWinsBTN config: ----------------------------------
        showWinsBTN = new JButton("Show Wins");
        showWinsBTN.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        showWinsBTN.setFocusable(false);
        showWinsBTN.setBackground(NAVY_BLUE);
        showWinsBTN.setForeground(WHITE);
        showWinsBTN.addActionListener(new ShowWinsBTNListener(this));

// ---- buttonPanel config: -----------------------------------
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(BLUE);
        buttonPanel.add(playBTN);
        buttonPanel.add(resetBoardBTN);
        buttonPanel.add(showWinsBTN);
        titlePanel.setPreferredSize(new Dimension(750, 68));

//----- Adding Components to JFrame: --------------------------
        this.add(ticTacPanel, "Center");
        this.add(titlePanel, "North");
        this.add(buttonPanel, "South");
        this.add(eastPanel, "East");
        this.add(westPanel, "West");

        setLocationRelativeTo(null); // Centres the JFrame.
        setResizable(false);
        setVisible(true);
    }
}
/*

Plan:
    - JFrame:
        - Border layout manager.
        - Background colour: BLUE.
    - Centre JPanel (whiteBGPanel):
        - null layout manager.
        - Background colour: WHITE
        - 370px x 370px size.
        - Add another JPanel (containing tic-tac-toe buttons) to (x,y) coordinates of (10, 10).
            - Tic-Tac-Toe Panel (ticTacPanel):
                - Grid layout manager - 4x4 grid, one cell for each button
                    - Background colour: SKY_BLUE
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
