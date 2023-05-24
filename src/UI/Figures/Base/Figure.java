package UI.Figures.Base;

import UI.Field;
import UI.Interfaces.IFigure;

import java.awt.*;

public abstract class Figure implements IFigure {
    public Color FigureColor;

    public Field[] Cells;

    @Override
    public Field[] GetCells() {
        return DeepClone();
    }

    public Figure(Color color) {
        FigureColor = color;

        Cells = new Field[] {
                new Field(FigureColor),
                new Field(FigureColor),
                new Field(FigureColor),
                new Field(FigureColor) };

        SetStartPosition();
    }

    @Override
    public abstract void SetStartPosition();

    @Override
    public void MoveDown() {
        Cells[0].Position.y++;
        Cells[1].Position.y++;
        Cells[2].Position.y++;
        Cells[3].Position.y++;
    }

    @Override
    public Field[] MoveDownPrediction() {
        var prediction = DeepClone();

        prediction[0].Position.y++;
        prediction[1].Position.y++;
        prediction[2].Position.y++;
        prediction[3].Position.y++;

        return prediction;
    }

    @Override
    public void Rotate() {
        var tempX = Cells[0].Position.x;
        var tempY = Cells[0].Position.y;

        for (Field field : Cells) {
            field.Position.x -= tempX;
            field.Position.y -= tempY;
        }

        for (Field cell : Cells) {
            cell.Position = new Point(cell.Position.y, cell.Position.x);
        }

        for (Field cell : Cells) {
            cell.Position.x += tempX;
            cell.Position.y += tempY;
        }
    }

    @Override
    public Field[] RotatePrediction() {
        var prediction = DeepClone();

        var tempX = prediction[0].Position.x;
        var tempY = prediction[0].Position.y;

        for (Field field : prediction) {
            field.Position.x -= tempX;
            field.Position.y -= tempY;
        }

        for (Field cell : prediction) {
            cell.Position = new Point(cell.Position.y, cell.Position.x);
        }

        for (Field cell : prediction) {
            cell.Position.x += tempX;
            cell.Position.y += tempY;
        }

        return prediction;
    }

    @Override
    public void MoveRight() {
        Cells[0].Position.x++;
        Cells[1].Position.x++;
        Cells[2].Position.x++;
        Cells[3].Position.x++;
    }

    @Override
    public Field[] MoveRightPrediction() {
        var prediction = DeepClone();

        prediction[0].Position.x++;
        prediction[1].Position.x++;
        prediction[2].Position.x++;
        prediction[3].Position.x++;

        return prediction;
    }

    @Override
    public void MoveLeft() {
        Cells[0].Position.x--;
        Cells[1].Position.x--;
        Cells[2].Position.x--;
        Cells[3].Position.x--;
    }

    @Override
    public Field[] MoveLeftPrediction() {
        var prediction = DeepClone();

        prediction[0].Position.x--;
        prediction[1].Position.x--;
        prediction[2].Position.x--;
        prediction[3].Position.x--;

        return prediction;
    }

    public Field[] DeepClone() {
        Field[] result = new Field[Cells.length];

        for (int i = 0; i < Cells.length; i++) {
            result[i] = Cells[i].Copy();
        }

        return result;
    }
}
