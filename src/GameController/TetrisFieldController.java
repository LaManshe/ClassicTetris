package GameController;

import Helpers.RandomFigureCreator;
import UI.Field;
import UI.Interfaces.IFigure;

import java.awt.*;
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
        if (CanMove(CurrentFigure.RotatePrediction())) {
            CurrentFigure.Rotate();

            UpdateFields();
        }
    }

    public void MoveRightFigure() {
        if (CanMove(CurrentFigure.MoveRightPrediction())) {
            CurrentFigure.MoveRight();

            UpdateFields();
        }
    }

    private boolean CanMove(Field[] fields) {
        var isNotOutOfRange = Arrays.stream(fields).noneMatch(field ->
                field.Position.x < 0 ||
                field.Position.x > _columns - 1 ||
                field.Position.y < 0 ||
                field.Position.y > _rows - 1);

        var isNotInFallenFields = true;

        for (Field fallen : AlreadyFallenFields) {
            if (Arrays.stream(fields).anyMatch(field ->
                    field.Position.x == fallen.Position.x && field.Position.y == fallen.Position.y)) {
                isNotInFallenFields = false;
            }
        }

        return isNotOutOfRange && isNotInFallenFields;
    }

    public void MoveLeftFigure() {
        if (CanMove(CurrentFigure.MoveLeftPrediction())) {
            CurrentFigure.MoveLeft();

            UpdateFields();
        }
    }

    private void UpdateFields() {
        Fields = InitGameField();

        if (CurrentFigure != null) {
            for (Field cell : CurrentFigure.GetCells()) {
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
        if (CanMove(CurrentFigure.MoveDownPrediction())) {
            CurrentFigure.MoveDown();
        }
        else {
            AlreadyFallenFields.addAll(Arrays.stream(CurrentFigure.GetCells()).toList());

            CurrentFigure = null;
            IsFigureFallingNow = false;
        }
    }

    private Field[][] InitGameField() {
        var result = new Field[_columns][_rows];

        for (int i = 0; i < _columns; i++) {
            for (int j = 0; j < _rows; j++) {
                result[i][j] = new Field(new Color(255, 255, 255, 0));
            }
        }

        return result;
    }
}
