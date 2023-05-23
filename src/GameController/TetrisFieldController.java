package GameController;

import Helpers.RandomFigureCreator;
import UI.Field;
import UI.Interfaces.IFigure;

import java.util.ArrayList;
import java.util.Arrays;

public class TetrisFieldController {
    private int _columns;

    private int _rows;

    public boolean IsFigureFallingNow;

    public Field[][] Fields;

    public IFigure CurrentFigure;

    public ArrayList<Field> AlreadyFallenFields;

    public TetrisFieldController(int columns, int rows) {
        _columns = columns;
        _rows = rows;

        IsFigureFallingNow = false;

        Fields = InitGameField();

        AlreadyFallenFields = new ArrayList<>();
    }

    public void Tick() {
        if (IsFigureFallingNow) {
            FigureMoveDown();
        }
        else {
            SpawnFigure();
        }

        UpdateFields();
    }

    public void RotateFigure() {
        CurrentFigure.Rotate();

        UpdateFields();
    }

    public void MoveRightFigure() {
        CurrentFigure.MoveRight();

        UpdateFields();
    }

    public void MoveLeftFigure() {
        CurrentFigure.MoveLeft();

        UpdateFields();
    }

    private void UpdateFields() {
        Fields = InitGameField();

        if (CurrentFigure != null) {
            for (Field cell : CurrentFigure.Cells()) {
                Fields[cell.Position.x][cell.Position.y] = cell;
            }
        }

        for (Field cell : AlreadyFallenFields) {
            Fields[cell.Position.x][cell.Position.y] = cell;
        }
    }

    private void SpawnFigure() {
        CurrentFigure = RandomFigureCreator.GetFigure();

        IsFigureFallingNow = true;
    }

    private void FigureMoveDown() {
        if (CanFigureMoveDown(CurrentFigure.Cells())) {
            CurrentFigure.MoveDown();
        }
        else {
            AlreadyFallenFields.addAll(Arrays.stream(CurrentFigure.Cells()).toList());

            CurrentFigure = null;
            IsFigureFallingNow = false;
        }
    }

    private boolean CanFigureMoveDown(Field[] figureFields) {
        if (Arrays.stream(figureFields).anyMatch(x -> x.Position.y >= _rows - 1)) {
            return false;
        }

        return Arrays.stream(figureFields).noneMatch(figureCell ->
                AlreadyFallenFields.stream().anyMatch(fallen ->
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
