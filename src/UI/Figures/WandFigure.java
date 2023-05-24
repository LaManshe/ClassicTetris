package UI.Figures;

import UI.Figures.Base.Figure;

import java.awt.*;

public class WandFigure extends Figure {

    public WandFigure(Color color) {
        super(color);

        SetStartPosition();
    }

    @Override
    public void SetStartPosition() {
        Cells[0].IsBusy = true;
        Cells[0].Position = new Point(0, 0);

        Cells[1].IsBusy = true;
        Cells[1].Position = new Point(1, 0);

        Cells[2].IsBusy = true;
        Cells[2].Position = new Point(2, 0);

        Cells[3].IsBusy = true;
        Cells[3].Position = new Point(3, 0);
    }
}
