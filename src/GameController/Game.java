package GameController;

import GameController.Interfaces.IStartListeners;
import GameController.Interfaces.ILayout;
import GameController.Layouts.Menu;
import GameController.Layouts.Tetris;
import Window.TetrisWindow;

public class Game implements IStartListeners {
    private final TetrisWindow _window;

    private final Menu _menu;

    private final Tetris _tetris;

    private ILayout _currentLayout;

    public Game() {
        _window = new TetrisWindow();

        _menu = new Menu();
        _tetris = new Tetris();

        _currentLayout = _menu;
    }

    @Override
    public void onButtonClick() {
        _currentLayout = _tetris;

        ShowCurrentLayout();
    }

    public void Start() {
        ShowCurrentLayout();
    }

    private void ShowCurrentLayout() {
        _currentLayout.Configure(_window, this);

        _window.Show();
    }
}
