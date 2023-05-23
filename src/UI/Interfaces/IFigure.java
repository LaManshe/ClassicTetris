package UI.Interfaces;

import UI.Field;

public interface IFigure {
    Field[] Cells();

    void SetStartPosition();

    Field[] NextMoveDownPosition();

    void MoveDown();

    void Rotate();

    void MoveRight();

    void MoveLeft();
}
