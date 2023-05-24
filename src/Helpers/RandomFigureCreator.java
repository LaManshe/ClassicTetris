package Helpers;

import UI.Figures.*;
import UI.Interfaces.IFigure;

import java.awt.*;
import java.util.Random;

public class RandomFigureCreator {
    public static IFigure GetFigure() {
        Random random = new Random();
        int randomNumber = random.nextInt(8);
        var randomColor = switch (random.nextInt(4)) {
            case 0 -> Color.BLUE;
            case 1 -> Color.RED;
            case 2 -> Color.YELLOW;
            case 3 -> Color.GREEN;
            default -> Color.BLUE;
        };

        return switch (randomNumber) {
            case 0 -> new WandFigure(randomColor);
            case 1 -> new BoxFigure(randomColor);
            case 2 -> new LFigure(randomColor);
            case 3 -> new SFigure(randomColor);
            case 4 -> new TFigure(randomColor);
            case 5 -> new ReLFigure(randomColor);
            case 6 -> new ReSFigure(randomColor);
            case 7 -> new ReTFigure(randomColor);
            default -> null;
        };

    }
}
