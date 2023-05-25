package UI;

import UI.Interfaces.IFigure;

import java.awt.*;

public class FigurePredictionPanel extends SizablePanel {
    Field[][] Matrix;

    public FigurePredictionPanel(int width, int height) {
        super(width, height);

        setLocation(402, 500);

        Matrix = InitMatrix();
    }

    public void SetFigure(IFigure figure) {
        Matrix = InitMatrix();

        for (Field fig : figure.GetMatrixView()) {
            Matrix[fig.Position.x][fig.Position.y] = fig;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Draw(g);
    }

    private void Draw(Graphics g) {
        int cellWidth = getWidth() / 5 - 5;
        int cellHeight = cellWidth;

        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int cellX = i * cellWidth;
                int cellY = j * cellHeight;

                if (Matrix[i][j].IsBusy) {
                    g.setColor(Matrix[i][j].MyColor);
                    g.fillRect(cellX, cellY, cellWidth, cellHeight);
                }

                g.setColor(Color.BLACK);
                g.drawRect(cellX, cellY, cellWidth, cellHeight);
            }
        }
    }

    private Field[][] InitMatrix() {
        var result = new Field[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[i][j] = new Field(new Color(255, 255, 255, 0));
            }
        }

        return result;
    }
}
