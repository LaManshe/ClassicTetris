package UI;

import Helpers.RandomFigureCreator;
import UI.Interfaces.IFigure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GameController {
    private boolean _isFigureFalling;

    private IFigure _currentFallingFigure;

    private final int _columns;

    private final int _rows;

    public Field[][] Fields;

    public ArrayList<Field> FallenFieldsContainer;

    public GameController(int countColumns, int countRows) {
        _isFigureFalling = false;
        _columns = countColumns;
        _rows = countRows;

        Fields = InitGameField();
        FallenFieldsContainer = new ArrayList<>();
    }

    public void Update() {
        if (_isFigureFalling) {
            FigureDown();

            UpdateFields();

            return;
        }

        if (CanCreateFigure()) {
            _currentFallingFigure = CreateFigure();

            _isFigureFalling = true;

            UpdateFields();
        }
    }

    private boolean CanCreateFigure() {
        return true;
    }

    private void UpdateFields() {
        Fields = InitGameField();

        if (_currentFallingFigure != null) {
            for (Field cell : _currentFallingFigure.Cells()) {
                Fields[cell.Position.x][cell.Position.y] = cell;
            }
        }

        for (Field cell : FallenFieldsContainer) {
            Fields[cell.Position.x][cell.Position.y] = cell;
        }
    }

    private IFigure CreateFigure() {
        var figure = RandomFigureCreator.GetFigure();

        Objects.requireNonNull(figure).SetStartPosition();

        return figure;
    }

    private void FigureDown() {
        if (CanMoveDown()) {
            _currentFallingFigure.MoveDown();

            return;
        }

        FallenFieldsContainer.addAll(Arrays.stream(_currentFallingFigure.Cells()).toList());

        _currentFallingFigure = null;
        _isFigureFalling = false;
    }

    private boolean CanMoveDown() {
        var array = _currentFallingFigure.Cells();

        if (Arrays.stream(array).anyMatch(x -> x.Position.y >= _rows - 1)) {
            return false;
        }

        return Arrays.stream(array).noneMatch(figureCell ->
                FallenFieldsContainer.stream().anyMatch(fallen ->
                        fallen.Position.y == figureCell.Position.y + 1));
    }

    private Field[][] InitGameField() {
        var result = new Field[_columns][_rows];

        for (int i = 0; i < _columns; i++) {
            for (int j = 0; j < _rows; j++) {
                result[i][j] = new Field();
            }
        }

        return result;
    }
}
