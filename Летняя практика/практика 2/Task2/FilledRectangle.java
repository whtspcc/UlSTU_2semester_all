package Task2;

import java.awt.Color;
import java.awt.Graphics2D;

public class FilledRectangle extends Shape{
    public FilledRectangle(int width, int height, Color color) {
        super(width, height, color);
        filled = true;
    }

    @Override
    protected void drawSimple(int x, int y, Graphics2D g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    protected void drawFilled(int x, int y, Graphics2D g) {
        g.fillRect(x, y, width, height);
    }
}
