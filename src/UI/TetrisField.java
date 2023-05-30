package UI;

import GameController.Interfaces.IKeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisField extends SizablePanel {
    private Field[][] Fields;

    public TetrisField(int width, int height, Field[][] fields) {
        super(width + 2, height + 2);

        Fields = fields;

        setFocusable(true);
        requestFocusInWindow();
    }

    public void Redraw(Field[][] fields) {
        Fields = fields;

        repaint();
    }

    public void EnableKeyEvents(IKeyboardListener listener) {
        var im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        var am = getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

        am.put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onSpaceClick();
            }
        });

        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onLeftArrowClick();
            }
        });

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onRightArrowClick();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DrawGrid(g);
    }

    private void DrawGrid(Graphics g) {
        int cellWidth = getWidth() / Fields.length - 2;
        int cellHeight = getHeight() / Fields[0].length - 2;

        g.setColor(Color.BLACK);
        for (int i = 0; i < Fields.length; i++) {
            for (int j = 0; j < Fields[0].length; j++) {
                int cellX = i * cellWidth;
                int cellY = j * cellHeight;

                if (Fields[i][j].IsBusy) {
                    g.setColor(Fields[i][j].MyColor);
                    g.fillRect(cellX, cellY, cellWidth, cellHeight);
                }

                g.setColor(Color.GRAY);
                g.drawRect(cellX, cellY, cellWidth, cellHeight);
            }
        }
    }
}
