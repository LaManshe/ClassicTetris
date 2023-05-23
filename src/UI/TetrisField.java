package UI;

import java.awt.*;

public class TetrisField extends SizablePanel {
    private final int CountRows = 20;

    private final int CountColumns = 10;

    public UI.GameController GameController;

    public TetrisField(int width, int height) {
        super(width + 2, height + 2);

        GameController = new GameController(CountColumns, CountRows);
    }

    @Override
    protected void paintComponent(Graphics g) {
        GameController.Update();

        super.paintComponent(g);

        DrawGrid(g);
    }

    private void DrawGrid(Graphics g) {
        int cellWidth = getWidth() / CountColumns - 2;
        int cellHeight = getHeight() / CountRows - 2;

        g.setColor(Color.BLACK);
        for (int i = 0; i < CountColumns; i++) {
            for (int j = 0; j < CountRows; j++) {
                int cellX = i * cellWidth;
                int cellY = j * cellHeight;

                if (GameController.Fields[i][j].IsBusy) {
                    g.setColor(Color.RED);
                    g.fillRect(cellX, cellY, cellWidth, cellHeight);
                }

                g.setColor(Color.BLACK);
                g.drawRect(cellX, cellY, cellWidth, cellHeight);
            }
        }
    }
}
