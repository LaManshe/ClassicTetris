package UI;

import java.awt.*;

public class Field {
    public Color MyColor;

    public Point Position;

    public boolean IsBusy;

    public Field(Color color) {
        IsBusy = false;
        Position = new Point(-1, -1);
        MyColor = color;
    }

    public Field Copy() {
        var result = new Field(MyColor);
        result.IsBusy = IsBusy;
        result.Position = (Point) Position.clone();
        return result;
    }
}
