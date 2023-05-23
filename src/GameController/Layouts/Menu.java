package GameController.Layouts;

import GameController.Interfaces.IStartListeners;
import GameController.Interfaces.ILayout;
import UI.BackgroundPanel;
import UI.Base.MyButton;
import UI.SizablePanel;
import UI.Title;
import Window.TetrisWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ILayout {
    public Menu() {
    }

    public void Configure(TetrisWindow window, IStartListeners listener) {
        window.Clean();

        var contentPanel = new BackgroundPanel(window.Content());

        var menuPanel = new SizablePanel(window.Content().getWidth(), 400);

        var buttonStart = new MyButton("Играть");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onButtonClick();
            }
        });

        menuPanel.addRangeCentered(
                new Title("Классический тетрис", new Dimension(menuPanel.getWidth(), 50)),
                buttonStart);

        contentPanel.addCentered(menuPanel);

        window.Content().add(contentPanel);
    }
}
