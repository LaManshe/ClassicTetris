package UI;

import UI.Base.MyPanel;

import javax.swing.*;

public class BackgroundPanel extends MyPanel {
    public BackgroundPanel(JFrame frame) {
        setBounds(0, 0, frame.getWidth(), frame.getHeight());
    }
}
