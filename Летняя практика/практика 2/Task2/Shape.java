package Task2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape implements Drawable {
    protected int width;
    protected int height;
    protected Color color;
    protected boolean filled;

    public Shape(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        Graphics2D g = (Graphics2D) canvas.getGraphics();
        g.setColor(color);
        if (filled) {
            drawFilled(x, y, g);
        } else {
            drawSimple(x, y, g);
        }
    }

    protected abstract void drawFilled(int x, int y, Graphics2D g);

    protected abstract void drawSimple(int x, int y, Graphics2D g);
}
