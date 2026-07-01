package Task2;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape{
    public Circle(int radius, Color color) {
        super(radius * 2, radius * 2, color);
        filled = false;
    }

    @Override
    protected void drawSimple(int x, int y, Graphics2D g) {
        g.drawOval(x, y, width,  height);
    }

    @Override
    protected void drawFilled(int x, int y, Graphics2D g) {
        g.fillOval(x, y, width, height);
    }
}
