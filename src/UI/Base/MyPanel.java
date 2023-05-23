package UI.Base;

import Helpers.LocationHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public ArrayList<Component> Childrens;

    public MyPanel() {
        Childrens = new ArrayList<>();

        setLayout(null);
    }

    @Override
    public Component add(Component comp) {
        Childrens.add(comp);

        return super.add(comp);
    }

    public Component addCentered(Component comp) {
        comp.setLocation(LocationHelper.GetCenterOfTwoDimension(getSize(), comp.getSize()));

        return add(comp);
    }

    public void addRangeCentered(Component... components) {
        var rowsNeeded = components.length;

        for (int i = 0; i < rowsNeeded; i++) {
            var dim = new Dimension(getWidth(), getHeight() / rowsNeeded);

            components[i].setLocation(LocationHelper.GetCenterOfTwoDimensionWithOffset(
                    dim,
                    components[i].getSize(),
                    new Point(0, getHeight() * i / rowsNeeded)));
            add(components[i]);
        }
    }
}
