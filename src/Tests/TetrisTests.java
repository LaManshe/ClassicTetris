package Tests;

import GameController.TetrisFieldController;
import UI.Field;
import UI.Figures.WandFigure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TetrisTests {
    @Test
    public void Test_CanFigureMoveFromStart() {
        var tetrisFieldController = new TetrisFieldController(10, 20);
        var figure = new WandFigure(Color.BLACK);

        var figureWithNextPos = figure.MoveDownPrediction();

        Assert.assertTrue(tetrisFieldController.CanMove(figureWithNextPos));
    }

    @Test
    public void Test_CanFigureMoveFromPosition() {
        var tetrisFieldController = new TetrisFieldController(10, 20);
        var figure = new WandFigure(Color.BLACK);

        Field field1 = new Field(Color.BLACK);
        field1.Position = new Point(5, 19);

        Field field2 = new Field(Color.BLACK);
        field2.Position = new Point(4, 19);

        Field field3 = new Field(Color.BLACK);
        field3.Position = new Point(3, 19);

        Field field4 = new Field(Color.BLACK);
        field4.Position = new Point(2, 19);

        figure.Cells = new Field[] {field1, field2, field3, field4};

        var figureWithNextPos = figure.MoveDownPrediction();

        Assert.assertFalse(tetrisFieldController.CanMove(figureWithNextPos));
    }

    @Test
    public void Test_CanFigureMoveWithOther() {
        var tetrisFieldController = new TetrisFieldController(10, 20);

        Field fallenfield1 = new Field(Color.BLACK);
        fallenfield1.Position = new Point(7, 15);

        Field fallenfield2 = new Field(Color.BLACK);
        fallenfield2.Position = new Point(6, 15);

        Field fallenfield3 = new Field(Color.BLACK);
        fallenfield3.Position = new Point(5, 15);

        Field fallenfield4 = new Field(Color.BLACK);
        fallenfield4.Position = new Point(4, 15);

        tetrisFieldController.AlreadyFallenFields.add(fallenfield1);
        tetrisFieldController.AlreadyFallenFields.add(fallenfield2);
        tetrisFieldController.AlreadyFallenFields.add(fallenfield3);
        tetrisFieldController.AlreadyFallenFields.add(fallenfield4);

        var figure = new WandFigure(Color.BLACK);

        Field field1 = new Field(Color.BLACK);
        field1.Position = new Point(5, 14);

        Field field2 = new Field(Color.BLACK);
        field2.Position = new Point(4, 14);

        Field field3 = new Field(Color.BLACK);
        field3.Position = new Point(3, 14);

        Field field4 = new Field(Color.BLACK);
        field4.Position = new Point(2, 14);

        figure.Cells = new Field[] {field1, field2, field3, field4};

        var figureWithNextPos = figure.MoveDownPrediction();

        Assert.assertFalse(tetrisFieldController.CanMove(figureWithNextPos));
    }
}
