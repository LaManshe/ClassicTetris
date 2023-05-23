package UI.Interfaces;

import UI.Field;

public interface IFigure {
    Field[] Cells();

    void SetStartPosition();

    void MoveDown();

    void Rotate();
}
