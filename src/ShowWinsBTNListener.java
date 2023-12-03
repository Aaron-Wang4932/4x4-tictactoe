import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowWinsBTNListener implements ActionListener {
    // Current Active JFrame:
    TicTacFrame ticTacFrame;
    // # wins per player:
    int[] wins = new int[3]; // index 0: X wins, index 1: O wins, index 2: ties
    public ShowWinsBTNListener(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp;
        int count = 0;
        try {
            BufferedReader winsReader = new BufferedReader(new FileReader("resources/wins.txt"));
            while((temp = winsReader.readLine()) != null) {
                wins[count] = Integer.parseInt(temp);
                count++;
            }
            winsReader.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ticTacFrame, "Something went wrong! :(", "Note:", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(ticTacFrame,
                "X Wins: " + wins[0] + "\nO Wins: " + wins[1] + "\nTie Games: " + wins[2],
                "Wins Log:",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("resources/partying_face.png"));
    }
}
