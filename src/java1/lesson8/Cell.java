package java1.lesson8;

import java.awt.*;

import static java1.lesson8.GameSnake.SNAKE_HEAD_COLOR;

public class Cell {
    private int x;
    private int y;
    private int size;
    private Color color;

    public Cell(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillOval(x * size, y * size, size, size);
    }

    public void paint2(Graphics2D graphics2D){
        graphics2D.setColor(SNAKE_HEAD_COLOR);
        graphics2D.fillOval(x * size, y * size, size, size);
    }
}
