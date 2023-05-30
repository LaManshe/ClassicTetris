package Window;

import javax.swing.*;

public class TetrisWindow {
    private JFrame _frame;

    private boolean _isVisible;

    public JFrame Content() {
        return _frame;
    }

    public TetrisWindow() {
        _isVisible = false;

        InitWindow();
    }

    public void Show() {
        _isVisible = true;

        _frame.setVisible(_isVisible);
    }

    public void Clean() {
        _frame.getContentPane().removeAll();
        _frame.revalidate();
        _frame.repaint();
    }

    private void InitWindow() {
        _frame = new JFrame("Классический тетрис");

        _frame.setSize(600, 800);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(false);
        _frame.setLocationRelativeTo(null);
    }
}
