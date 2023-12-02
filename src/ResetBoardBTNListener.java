import javax.swing.*;
import java.awt.event.*;

public class ResetBoardBTNListener implements ActionListener {
    TicTacFrame ticTacFrame;
    public ResetBoardBTNListener(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton button : ticTacFrame.ticTacBTNS) button.setText("");
        TicTacBTNListener.isXTurn = true;
        TicTacBTNListener.numClicks = 0;
        TicTacBTNListener.winnerExists = false;
        for(int i = 0; i < 16; i++) TicTacBTNListener.curBoard[i] = ' ';
    }
}
