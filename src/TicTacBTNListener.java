import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacBTNListener implements ActionListener {
    // Current Active JFrame:
    TicTacFrame ticTacFrame;
    /*
    * Current Board State:
    * Whitespace (" ") represents an empty slot.
    * "X" represents an X in that slot.
    * "O" represents an O in that slot.
    */
    private static final char[] curBoard = new char[16];
    // Colours
    Color XColor = new Color(0xFF96FD);
    Color OColor = new Color(0xA3D2FF);
    // Util:
    private static boolean isXTurn;
    public TicTacBTNListener(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
        //Initialize the board to an empty state.
        for(int i = 0; i < 16; i++) curBoard[i] = ' ';
        isXTurn = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = null;
        int buttonIndex = 0;
        // Gain access to the clicked button.
        for(int i = 0; i < 16; i++) {
            if(e.getSource() == ticTacFrame.ticTacBTNS[i]) {
                clickedButton = ticTacFrame.ticTacBTNS[i];
                buttonIndex = i;
            }
        }
        // Null check (it's never null though!)
        if(clickedButton == null ) {
            ticTacFrame.titleLabel.setText("something went wrong. :("); // this WILL NEVER RUN :)
            return;
        }
        // If this button has already been clicked:
        if(curBoard[buttonIndex] != ' ') {
            invalidMove();
            return;
        }
        clickedButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 130));
        // Set appropriate text.
        if(isXTurn) {
            clickedButton.setForeground(XColor);
            clickedButton.setText("X");
            curBoard[buttonIndex] = 'X';
            isXTurn = false;
        } else {
            clickedButton.setForeground(OColor);
            clickedButton.setText("O");
            curBoard[buttonIndex] = 'O';
            isXTurn = true;
        }
        checkForWin();
    }

    private void invalidMove() {
        System.out.println("bad move");
        // todo: make this a popup
    }

    private void checkForWin() {}

    public static void resetTurn() {
        isXTurn = true;
        //Initialize the board to an empty state.
        for(int i = 0; i < 16; i++) curBoard[i] = ' ';
    }
}
