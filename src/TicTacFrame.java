import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class TicTacFrame extends JFrame {
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
    JButton resetBoardBTN;
    JButton showWinsBTN;
    JButton[] ticTacBTNS = new JButton[16];
    public TicTacFrame() {
// ---- Frame config: ----------------------------------------
        this.setTitle("Tic Tac Toe.. Toc?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(660, 660);
        this.getContentPane().setBackground(WHITE);
        this.setIconImage(new ImageIcon("resources/TicTacToe.png").getImage());
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
        buttonPanel.add(resetBoardBTN);
        buttonPanel.add(showWinsBTN);
        titlePanel.setPreferredSize(new Dimension(750, 68));

//----- Adding Components to JFrame: --------------------------
        this.add(ticTacPanel, "Center");
        this.add(titlePanel, "North");
        this.add(buttonPanel, "South");
        this.add(eastPanel, "East");
        this.add(westPanel, "West");

        this.setLocationRelativeTo(null); // Centres the JFrame.
        this.setResizable(false);
        this.setVisible(true);

        Timer timer = new Timer(250, e -> JOptionPane.showMessageDialog(this,
                "The game has started!",
                "Note: ",
                javax.swing.JOptionPane.INFORMATION_MESSAGE));
        timer.setRepeats(false);
        timer.start();
    }
}