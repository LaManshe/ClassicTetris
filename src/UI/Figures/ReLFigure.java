package UI.Figures;

import java.awt.*;

public class ReLFigure extends LFigure{
    public ReLFigure(Color color) {
        super(color);
    }

    @Override
    public void SetStartPosition() {
        Cells[0].IsBusy = true;
        Cells[0].Position = new Point(4, 0);

        Cells[1].IsBusy = true;
        Cells[1].Position = new Point(4, 1);

        Cells[2].IsBusy = true;
        Cells[2].Position = new Point(4, 2);

        Cells[3].IsBusy = true;
        Cells[3].Position = new Point(3, 2);
    }
}
