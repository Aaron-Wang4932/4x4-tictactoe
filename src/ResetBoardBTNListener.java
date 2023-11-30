import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetBoardBTNListener implements ActionListener {
    TicTacFrame ticTacFrame;
    public ResetBoardBTNListener(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton button : ticTacFrame.ticTacBTNS) button.setText("");
        TicTacBTNListener.resetTurn();
    }
}
