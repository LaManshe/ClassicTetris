package GameController;

import GameController.Interfaces.IKeyboardListener;
import GameController.Interfaces.ILineBuildedListeners;
import UI.FigurePredictionPanel;
import UI.RightPanel;
import UI.TetrisField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController extends Thread implements IKeyboardListener, ILineBuildedListeners {
    private final int _columns;

    private final int _rows;

    private Timer _timer;

    private TetrisFieldController _tetrisFieldController;

    private TetrisField _tetrisField;

    private RightPanelController _rightPanelController;

    private RightPanel _rightPanel;

    private FigurePredictionPanel _rightPredictionPanel;

    public TetrisField GetTetrisField() {
        return _tetrisField;
    }

    public RightPanel GetRightPanel() {
        return _rightPanel;
    }

    public FigurePredictionPanel GetPredictionPanel() {
        return _rightPredictionPanel;
    }

    public GameController(int countColumns, int countRows) {
        _columns = countColumns;
        _rows = countRows;

        _tetrisFieldController = new TetrisFieldController(_columns, _rows);
        _tetrisField = new TetrisField(400, 800, _tetrisFieldController.Fields);

        _rightPanelController = new RightPanelController();
        _rightPanel = new RightPanel(200, 500);

        _rightPredictionPanel = new FigurePredictionPanel(200, 300);

        _tetrisFieldController.AddListener(this);
    }

    @Override
    public void run() {
        super.run();

        _tetrisField.EnableKeyEvents(this);

        _timer = new Timer(500 - _rightPanelController.GetLevels() * 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });

        _timer.start();
    }

    public void Update() {
        _tetrisFieldController.Tick();

        _tetrisField.Redraw(_tetrisFieldController.Fields);

        _rightPredictionPanel.SetFigure(_tetrisFieldController.GetNextFigure());

        _timer.setDelay(500 - _rightPanelController.GetLevels() * 50);
    }

    @Override
    public void onSpaceClick() {
        _tetrisFieldController.RotateFigure();

        _tetrisField.Redraw(_tetrisFieldController.Fields);
    }

    @Override
    public void onRightArrowClick() {
        _tetrisFieldController.MoveRightFigure();

        _tetrisField.Redraw(_tetrisFieldController.Fields);
    }

    @Override
    public void onLeftArrowClick() {
        _tetrisFieldController.MoveLeftFigure();

        _tetrisField.Redraw(_tetrisFieldController.Fields);
    }

    @Override
    public void onLineBuilded() {
        _rightPanelController.IncrementLines();

        _rightPanel.Redraw(_rightPanelController);
    }
}
