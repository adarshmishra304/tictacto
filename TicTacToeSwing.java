import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeSwing extends JFrame implements ActionListener {

    JButton[][] btn = new JButton[3][3];
    JButton resetBtn;
    boolean xTurn = true;
    int moves = 0;

    public TicTacToeSwing() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel grid = new JPanel(new GridLayout(3, 3));
        Font f = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[i][j] = new JButton("");
                btn[i][j].setFont(f);
                btn[i][j].addActionListener(this);
                grid.add(btn[i][j]);
            }
        }

        resetBtn = new JButton("New Game ");
        resetBtn.setFont(new Font("Arial", Font.BOLD, 16));
        resetBtn.addActionListener(e -> resetGame());

        add(grid, BorderLayout.CENTER);
        add(resetBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (!b.getText().equals(""))
            return;

        b.setText(xTurn ? "X" : "O");
        moves++;

        if (checkWin()) {
            JOptionPane.showMessageDialog(this,
                    (xTurn ? "X" : "O") + " won!");
            disableButtons();
            return;
        }

        if (moves == 9) {
            JOptionPane.showMessageDialog(this, "Match Draw!");
            return;
        }

        xTurn = !xTurn;
    }

    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (same(btn[i][0], btn[i][1], btn[i][2])) return true;
            if (same(btn[0][i], btn[1][i], btn[2][i])) return true;
        }
        return same(btn[0][0], btn[1][1], btn[2][2]) ||
               same(btn[0][2], btn[1][1], btn[2][0]);
    }

    boolean same(JButton a, JButton b, JButton c) {
        return !a.getText().equals("") &&
               a.getText().equals(b.getText()) &&
               b.getText().equals(c.getText());
    }

    void disableButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                btn[i][j].setEnabled(false);
    }

    void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[i][j].setText("");
                btn[i][j].setEnabled(true);
            }
        }
        moves = 0;
        xTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToeSwing();
    }
}
