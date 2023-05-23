package UI;

import java.awt.*;

public class Field {
    public Point Position;

    public boolean IsBusy;

    public Field() {
        IsBusy = false;
        Position = new Point(-1, -1);
    }
}
