package GameController;

public class RightPanelController {
    private int _points;

    private int _levels;

    private int _lines;

    public RightPanelController() {
        _points = 0;
        _levels = 0;
        _lines = 0;
    }

    public int GetCountPoints() {
        return _points;
    }

    public void IncrementPoints(int count) {
        _points += count;
    }

    public int GetLevels() {
        return _levels;
    }

    public void IncrementLevel() {
        _levels ++;
    }

    public int GetLines() {
        return _lines;
    }

    public void IncrementLines() {
        _lines++;

        IncrementPoints(_lines * 10);

        if (_lines % 5 == 0) {
            IncrementLevel();
        }
    }
}
