package GameController;

import GameController.Interfaces.IKeyboardListener;
import GameController.Interfaces.ILineBuildedListeners;
import UI.RightPanel;
import UI.TetrisField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController extends Thread implements IKeyboardListener, ILineBuildedListeners {
    private final int _columns;

    private final int _rows;

    private TetrisFieldController _tetrisFieldController;

    private TetrisField _tetrisField;

    private RightPanelController _rightPanelController;

    private RightPanel _rightPanel;

    public TetrisField GetTetrisField() {
        return _tetrisField;
    }

    public RightPanel GetRightPanel() {
        return _rightPanel;
    }

    public GameController(int countColumns, int countRows) {
        _columns = countColumns;
        _rows = countRows;

        _tetrisFieldController = new TetrisFieldController(_columns, _rows);
        _tetrisField = new TetrisField(400, 800, _tetrisFieldController.Fields);

        _rightPanelController = new RightPanelController();
        _rightPanel = new RightPanel(200, 800);

        _tetrisFieldController.AddListener(this);
    }

    @Override
    public void run() {
        super.run();

        _tetrisField.EnableKeyEvents(this);

        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });

        timer.start();
    }

    public void Update() {
        _tetrisFieldController.Tick();

        _tetrisField.Redraw(_tetrisFieldController.Fields);
    }

    @Override
    public void onSpaceClick() {
        _tetrisFieldController.RotateFigure();
    }

    @Override
    public void onRightArrowClick() {
        _tetrisFieldController.MoveRightFigure();
    }

    @Override
    public void onLeftArrowClick() {
        _tetrisFieldController.MoveLeftFigure();
    }

    @Override
    public void onLineBuilded() {
        _rightPanelController.IncrementLines();

        _rightPanel.Redraw(_rightPanelController);
    }
}
