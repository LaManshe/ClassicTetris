package Helpers;

import UI.Interfaces.IFigure;
import UI.WandFigure;

import java.util.Random;

public class RandomFigureCreator {
    public static IFigure GetFigure() {
        Random random = new Random();
        int randomNumber = random.nextInt(3); // Генерируем случайное число от 0 до 2

        randomNumber = 0;
        if (randomNumber == 0) {
            return new WandFigure();
        }

        return null;
    }
}
