package UI;

import GameController.RightPanelController;

import java.awt.*;

public class RightPanel extends SizablePanel {
    private Title _pointsNumber;

    private Title _currentLevel;

    private Title _linesNumber;

    public int Points;

    public int Level;

    public int Lines;

    public RightPanel(int width, int height) {
        super(width, height);

        setLocation(400, 0);

        Points = 0;
        Level = 0;
        Lines = 0;

        var pointsLabel = new Title("Очки:", new Dimension(getWidth(), 50));

        _pointsNumber = new Title(
                Integer.toString(Points),
                new Dimension(getWidth(), 50));

        var levelLabel = new Title("Уровень", new Dimension(getWidth(), 50));

        _currentLevel = new Title(
                Integer.toString(Level),
                new Dimension(getWidth(), 50));

        var linesLabel = new Title("Линии", new Dimension(getWidth(), 50));

        _linesNumber = new Title(
                Integer.toString(Lines),
                new Dimension(getWidth(), 50));

        addRangeCentered(pointsLabel, _pointsNumber, levelLabel, _currentLevel, linesLabel, _linesNumber);
    }

    @Override
    protected void paintComponent(Graphics g) {
        _pointsNumber.setText(Integer.toString(Points));
        _currentLevel.setText(Integer.toString(Level));
        _linesNumber.setText(Integer.toString(Lines));

        super.paintComponent(g);
    }

    public void Redraw(RightPanelController contorller) {
        Points = contorller.GetCountPoints();
        Level = contorller.GetLevels();
        Lines = contorller.GetLines();

        repaint();
    }

    public void SetPoints(int newPoints) {
        Points = newPoints;

        repaint();
    }

    public void SetLevel(int newLevel) {
        Level = newLevel;

        repaint();
    }

    public void SetLines(int newLines) {
        Lines = newLines;

        repaint();
    }
}
