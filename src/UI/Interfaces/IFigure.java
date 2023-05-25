package UI.Interfaces;

import UI.Field;

import java.awt.*;

public interface IFigure {
    Field[] GetCells();

    Field[] GetMatrixView();

    void SetStartPosition();

    void SetPositionMatrixView();

    void MoveDown();

    Field[] MoveDownPrediction();

    void Rotate();

    Field[] RotatePrediction();

    void MoveRight();

    Field[] MoveRightPrediction();

    void MoveLeft();

    Field[] MoveLeftPrediction();

    Field[] DeepClone();
}
