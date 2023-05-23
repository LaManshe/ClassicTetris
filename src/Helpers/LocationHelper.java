package Helpers;

import java.awt.*;

public class LocationHelper {
    public static Point GetCenterOfTwoDimension(Dimension parent,
                                                Dimension object) {
        int positionX = Center(parent.width - object.width);
        int positionY = Center(parent.height - object.height);

        return new Point(positionX, positionY);
    }

    public static Point GetCenterOfTwoDimensionWithOffset(
            Dimension parent,
            Dimension object,
            Point offset) {
        int positionX = Center(parent.width - object.width) + offset.x;
        int positionY = Center(parent.height - object.height) + offset.y;

        return new Point(positionX, positionY);
    }

    public static int Center(int arg) {
        return arg / 2;
    }
}
