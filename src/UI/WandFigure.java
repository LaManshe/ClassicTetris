package UI;

import UI.Interfaces.IFigure;

import java.awt.*;
import java.util.Arrays;

public class WandFigure implements IFigure {
    private Field[] _cells;

    @Override
    public Field[] Cells() {
        return _cells;
    }

    public WandFigure() {
        _cells = new Field[] { new Field(), new Field(), new Field(), new Field() };

        SetStartPosition();
    }

    @Override
    public void SetStartPosition() {
        _cells[0].IsBusy = true;
        _cells[0].Position = new Point(0, 0);

        _cells[1].IsBusy = true;
        _cells[1].Position = new Point(1, 0);

        _cells[2].IsBusy = true;
        _cells[2].Position = new Point(2, 0);

        _cells[3].IsBusy = true;
        _cells[3].Position = new Point(3, 0);
    }

    @Override
    public Field[] NextMoveDownPosition() {
        var temp = Cells().clone();

        temp[0].Position.y++;
        temp[1].Position.y++;
        temp[2].Position.y++;
        temp[3].Position.y++;

        return temp;
    }

    @Override
    public void MoveDown() {
        _cells[0].Position.y++;
        _cells[1].Position.y++;
        _cells[2].Position.y++;
        _cells[3].Position.y++;
    }

    @Override
    public void Rotate() {
        if (CanRotate()) {
            var tempX = _cells[0].Position.x;
            var tempY = _cells[0].Position.y;

            for (int i = 0; i < _cells.length; i++) {
                _cells[i].Position.x -= tempX;
                _cells[i].Position.y -= tempY;
            }

            for (int i = 0; i < _cells.length; i++) {
                _cells[i].Position = new Point(_cells[i].Position.y, _cells[i].Position.x);
            }

            for (int i = 0; i < _cells.length; i++) {
                _cells[i].Position.x += tempX;
                _cells[i].Position.y += tempY;
            }
        }
    }

    @Override
    public void MoveRight() {
        _cells[0].Position.x++;
        _cells[1].Position.x++;
        _cells[2].Position.x++;
        _cells[3].Position.x++;
    }

    @Override
    public void MoveLeft() {
        _cells[0].Position.x--;
        _cells[1].Position.x--;
        _cells[2].Position.x--;
        _cells[3].Position.x--;
    }

    private boolean CanRotate() {
        return Arrays.stream(Cells()).noneMatch(cell -> cell.Position.y == 0);
    }
}
