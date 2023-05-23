package GameController.Layouts;

import GameController.Interfaces.ILayout;
import GameController.Interfaces.IStartListeners;
import UI.BackgroundPanel;
import UI.TetrisField;
import Window.TetrisWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tetris implements ILayout {

    @Override
    public void Configure(TetrisWindow window, IStartListeners listener) {
        window.Clean();

        var contentPanel = new BackgroundPanel(window.Content());

        var tetrisPanel = new TetrisField((int)(contentPanel.getWidth() * 0.6), contentPanel.getHeight());

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tetrisPanel.repaint();
            }
        });
        timer.start();

        contentPanel.add(tetrisPanel);

        window.Content().add(contentPanel);
    }
}
