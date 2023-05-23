package UI;

import UI.Base.MyText;

import java.awt.*;

public class Title extends MyText {
    public Title(String text, Dimension dim) {
        super(text, dim);

        setFont(new Font(getFont().getName(), Font.BOLD, 25));
    }
}
