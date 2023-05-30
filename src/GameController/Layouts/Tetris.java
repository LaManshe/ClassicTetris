package GameController.Layouts;

import GameController.Interfaces.ILayout;
import GameController.Interfaces.IStartListeners;
import UI.BackgroundPanel;
import GameController.GameController;
import Window.TetrisWindow;

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

        var rightPanel = GameController.GetRightPanel();

        var predictionPanel = GameController.GetPredictionPanel();

        contentPanel.add(tetrisPanel);
        contentPanel.add(rightPanel);
        contentPanel.add(predictionPanel);

        window.Content().add(contentPanel);

        GameController.start();
    }
}
