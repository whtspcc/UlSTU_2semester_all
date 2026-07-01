package Task2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Shape circle = new Circle(50, Color.RED);
        Shape FilledRectangle = new FilledRectangle(120, 80, Color.BLUE);

        circle.draw(40, 40, this);
        FilledRectangle.draw(180, 50, this);
    }
}
