import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TicTacBTNListener implements ActionListener {
    // Current Active JFrame:
    TicTacFrame ticTacFrame;
    ImageIcon winner = new ImageIcon("resources/tada.png");
    /*
    * Current Board State:
    * Whitespace (" ") represents an empty slot.
    * "X" represents an X in that slot.
    * "O" represents an O in that slot.
    */
    static final char[] curBoard = new char[16];
    /*
    [0]  [1]  [2]  [3]
    [4]  [5]  [6]  [7]
    [8]  [9]  [10] [11]
    [12] [13] [14] [15]
     */
    // Colours
    Color XColor = new Color(0xFF96FD);
    Color OColor = new Color(0x6CB6FF);
    // Util:
    static boolean isXTurn;
    static boolean winnerExists = false;
    static int numClicks = 0;
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

        if(winnerExists) {
            JOptionPane.showMessageDialog(ticTacFrame, "Please reset the board to play again!", "Note:", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Gain access to the clicked button.
        for(int i = 0; i < 16; i++) {
            if(e.getSource() == ticTacFrame.ticTacBTNS[i]) {
                clickedButton = ticTacFrame.ticTacBTNS[i];
                buttonIndex = i;
            }
        }
        // Null check (it's never null though!)
        if(clickedButton == null) {
            ticTacFrame.titleLabel.setText("something went wrong. :("); // this WILL NEVER RUN :)
            return;
        }
        // If this button has already been clicked:
        if(curBoard[buttonIndex] != ' ') {
            JOptionPane.showMessageDialog(ticTacFrame, "This is an invalid move!", "Note:", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Sets style.
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
        numClicks++;
        checkForWin();
    }
    private void checkForWin() {
        // I really don't like this.
        boolean rowCheckX = (curBoard[0] == 'X') && (curBoard[0] == curBoard[1]) && (curBoard[1] == curBoard[2]) && (curBoard[2] == curBoard[3])
                || (curBoard[4] == 'X') && (curBoard[4] == curBoard[5]) && (curBoard[5] == curBoard[6]) && (curBoard[6] == curBoard[7])
                || (curBoard[8] == 'X') && (curBoard[8] == curBoard[9]) && (curBoard[9] == curBoard[10]) && (curBoard[10] == curBoard[11])
                || (curBoard[12] == 'X') && (curBoard[12] == curBoard[13]) && (curBoard[13] == curBoard[14]) && (curBoard[14] == curBoard[15]);

        boolean colCheckX = (curBoard[0] == 'X') && (curBoard[0] == curBoard[4]) && (curBoard[4] == curBoard[8]) && (curBoard[8] == curBoard[12])
                || (curBoard[1] == 'X') && (curBoard[1] == curBoard[5]) && (curBoard[5] == curBoard[9]) && (curBoard[9] == curBoard[13])
                || (curBoard[2] == 'X') && (curBoard[2] == curBoard[6]) && (curBoard[6] == curBoard[10]) && (curBoard[10] == curBoard[14])
                || (curBoard[3] == 'X') && (curBoard[3] == curBoard[7]) && (curBoard[7] == curBoard[11]) && (curBoard[11] == curBoard[15]);

        boolean diagCheckX = (curBoard[0] == 'X') && (curBoard[0] == curBoard[5]) && (curBoard[5] == curBoard[10]) && (curBoard[10] == curBoard[15])
                || (curBoard[3] == 'X') && (curBoard[3] == curBoard[6]) && (curBoard[6] == curBoard[9]) && (curBoard[9] == curBoard[12]);

        boolean rowCheckO = (curBoard[0] == 'O') && (curBoard[0] == curBoard[1]) && (curBoard[1] == curBoard[2]) && (curBoard[2] == curBoard[3])
                || (curBoard[4] == 'O') && (curBoard[4] == curBoard[5]) && (curBoard[5] == curBoard[6]) && (curBoard[6] == curBoard[7])
                || (curBoard[8] == 'O') && (curBoard[8] == curBoard[9]) && (curBoard[9] == curBoard[10]) && (curBoard[10] == curBoard[11])
                || (curBoard[12] == 'O') && (curBoard[12] == curBoard[13]) && (curBoard[13] == curBoard[14]) && (curBoard[14] == curBoard[15]);

        boolean colCheckO = (curBoard[0] == 'O') && (curBoard[0] == curBoard[4]) && (curBoard[4] == curBoard[8]) && (curBoard[8] == curBoard[12])
                || (curBoard[1] == 'O') && (curBoard[1] == curBoard[5]) && (curBoard[5] == curBoard[9]) && (curBoard[9] == curBoard[13])
                || (curBoard[2] == 'O') && (curBoard[2] == curBoard[6]) && (curBoard[6] == curBoard[10]) && (curBoard[10] == curBoard[14])
                || (curBoard[3] == 'O') && (curBoard[3] == curBoard[7]) && (curBoard[7] == curBoard[11]) && (curBoard[11] == curBoard[15]);

        boolean diagCheckO = (curBoard[0] == 'O') && (curBoard[0] == curBoard[5]) && (curBoard[5] == curBoard[10]) && (curBoard[10] == curBoard[15])
                || (curBoard[3] == 'O') && (curBoard[3] == curBoard[6]) && (curBoard[6] == curBoard[9]) && (curBoard[9] == curBoard[12]);

        if(rowCheckX || colCheckX || diagCheckX) {
            JOptionPane.showMessageDialog(ticTacFrame, "X is the winner!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE, winner);
            winnerExists = true;
            writeToFile("X");
        } else if(rowCheckO || colCheckO || diagCheckO) {
            JOptionPane.showMessageDialog(ticTacFrame, "O is the winner!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE, winner);
            winnerExists = true;
            writeToFile("O");
        } else if(numClicks == 16) {
            JOptionPane.showMessageDialog(ticTacFrame, "The game is tied!", "Note:", JOptionPane.INFORMATION_MESSAGE, winner);
            winnerExists = true;
            writeToFile("TIE");
        }
    }

    private void writeToFile(String winner) {
        int[] wins = new int[3];
        String temp;
        int count = 0;

        // Read current wins from file.
        try {
            BufferedReader winsReader = new BufferedReader(new FileReader("resources/wins.txt"));
            while((temp = winsReader.readLine()) != null) {
                wins[count] = Integer.parseInt(temp);
                count++;
            }
            winsReader.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(ticTacFrame, "Something went wrong! :(", "Note:", JOptionPane.ERROR_MESSAGE);
        }
        // Switch-case to modify the winner.
        switch(winner) {
            case "X":
                wins[0]++;
                break;
            case "O":
                wins[1]++;
                break;
            case "TIE":
                wins[2]++;
                break;
            default:
                throw new IllegalArgumentException("Specified winner is not valid - choose between X, O, or TIE.");
        }
        try{
            BufferedWriter winsWriter = new BufferedWriter(new FileWriter("resources/wins.txt"));
            for(int i : wins) winsWriter.write(i + "\n");
            winsWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ticTacFrame, "Something went wrong! :(", "Note:", JOptionPane.ERROR_MESSAGE);
        }
    }
}
