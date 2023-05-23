package UI;

import UI.Interfaces.IFigure;

import java.awt.*;
import java.util.Arrays;

public class WandFigure implements IFigure {
    private final Field[] _cells;

    @Override
    public Field[] Cells() {
        return _cells;
    }

    public WandFigure() {
        _cells = new Field[] { new Field(), new Field(), new Field(), new Field() };
    }

    @Override
    public void SetStartPosition() {
        _cells[0].IsBusy = true;
        _cells[0].Position = new Point(4, 0);

        _cells[1].IsBusy = true;
        _cells[1].Position = new Point(5, 0);

        _cells[2].IsBusy = true;
        _cells[2].Position = new Point(6, 0);

        _cells[3].IsBusy = true;
        _cells[3].Position = new Point(7, 0);
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
            _cells[0].Position.x++;
            _cells[0].Position.y--;

            _cells[2].Position.x--;
            _cells[2].Position.y++;

            _cells[3].Position.x -= 2;
            _cells[3].Position.y += 2;
        }
    }

    private boolean CanRotate() {
        return Arrays.stream(Cells()).noneMatch(cell -> cell.Position.y == 0);
    }
}
