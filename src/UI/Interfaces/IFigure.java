package UI.Interfaces;

import UI.Field;

import java.awt.*;

public interface IFigure {
    Field[] GetCells();

    void SetStartPosition();

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
