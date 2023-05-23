package UI.Base;

import javax.swing.*;
import java.awt.*;

public class MyText extends JLabel {
    public MyText(String text, Dimension dim) {
        setBounds(0, 0, dim.width, dim.height);
        setHorizontalAlignment(JLabel.CENTER);
        setText(text);
    }
}
