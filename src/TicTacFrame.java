import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

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
    final Color NAVY_SKY_BLUE = new Color(0x2D3047); // Util. button colours
    final Color WHITE = new Color(0xFFFFFF); // Button Text, borders
    final Color SKY_BLUE = new Color(0x77B1FF); // Tic Tac Toe buttons
    final Color BLUE = new Color(0x6791FF); // Background
    final Color BLACK = new Color(0x000000); // Tic Tac Toe Lines

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
    JButton[][] ticTacBTNS = new JButton[4][4];

    // Util:
    int curTicTacBTNNum = 1;

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
        ticTacPanel.setLayout(new GridLayout(4, 4, 20, 20));
        ticTacPanel.setBackground(BLACK);
//        ticTacPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                ticTacBTNS[i][j] = new JButton(curTicTacBTNNum + "");
                ticTacBTNS[i][j].setBackground(SKY_BLUE);
                ticTacBTNS[i][j].setFocusable(false);
                ticTacBTNS[i][j].setSize(new Dimension(120, 120));
                ticTacBTNS[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
                ticTacPanel.add(ticTacBTNS[i][j]);
                curTicTacBTNNum++;
            }
        }

// ---- titleLabel config: ------------------------------------
        titleLabel = new JLabel("Tic Tac Toe.. Toc?");
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
        titleLabel.setForeground(WHITE);

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
        playBTN.setBackground(NAVY_SKY_BLUE);
        playBTN.setForeground(WHITE);

// ---- resetBoardBTN config: ---------------------------------
        resetBoardBTN = new JButton("Reset Board");
        resetBoardBTN.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        resetBoardBTN.setFocusable(false);
        resetBoardBTN.setBackground(NAVY_SKY_BLUE);
        resetBoardBTN.setForeground(WHITE);

// ---- showWinsBTN config: ----------------------------------
        showWinsBTN = new JButton("Show Wins");
        showWinsBTN.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        showWinsBTN.setFocusable(false);
        showWinsBTN.setBackground(NAVY_SKY_BLUE);
        showWinsBTN.setForeground(WHITE);
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
