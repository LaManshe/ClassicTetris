package GameController.Layouts;

import GameController.Interfaces.ILayout;
import GameController.Interfaces.IStartListeners;
import UI.BackgroundPanel;
import GameController.GameController;
import Window.TetrisWindow;

import javax.swing.*;

public class Tetris implements ILayout {
    private final int CountColumns = 10;

    private final int CountRows = 20;

    public GameController GameController;

    public Tetris() {
        GameController = new GameController(CountColumns, CountRows);
    }

    @Override
    public void Configure(TetrisWindow window, IStartListeners listener) {
        window.Clean();

        var contentPanel = new BackgroundPanel(window.Content());

        var tetrisPanel = GameController.GetTetrisField();

        contentPanel.add(tetrisPanel);

        window.Content().add(contentPanel);

        GameController.start();
    }
}
