package Tests;

import GameController.TetrisFieldController;
import UI.Field;
import UI.Figures.WandFigure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MoveRightTests {
    @Test
    public void Test_MoveRightFromStart() {
        var tetrisFieldController = new TetrisFieldController(10, 20);

        var figure = new WandFigure(Color.BLACK);

        var startPosition = figure.DeepClone();

        tetrisFieldController.CurrentFigure = figure;

        tetrisFieldController.MoveRightFigure();

        for (var i = 0; i < startPosition.length; i++) {
            Assert.assertEquals(startPosition[i].Position.x + 1, figure.Cells[i].Position.x);
        }
    }

    @Test
    public void Test_MoveRightCloseToBorder() {
        var tetrisFieldController = new TetrisFieldController(10, 20);

        var figure = new WandFigure(Color.BLACK);

        var field1 = new Field(Color.BLACK);
        field1.Position = new Point(9, 1);
        var field2 = new Field(Color.BLACK);
        field2.Position = new Point(9, 2);
        var field3 = new Field(Color.BLACK);
        field3.Position = new Point(9, 3);
        var field4 = new Field(Color.BLACK);
        field4.Position = new Point(9, 4);

        figure.Cells = new Field[] { field1, field2, field3, field4 };

        var startPosition = figure.DeepClone();

        tetrisFieldController.CurrentFigure = figure;

        tetrisFieldController.MoveRightFigure();

        for (var i = 0; i < startPosition.length; i++) {
            Assert.assertEquals(startPosition[i].Position.x, figure.Cells[i].Position.x);
        }
    }
}
