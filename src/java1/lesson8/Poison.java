package java1.lesson8;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java1.lesson8.GameSnake.CANVAS_HEIGHT;
import static java1.lesson8.GameSnake.CANVAS_WIDTH;

public class Poison {
    private List<Cell> poison;
    private Random random;
    private Food food;
    private Snake snake;

    public Poison(Snake snake){
        poison = new ArrayList<>();
        random = new Random();
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean isPoison(int x, int y){
        for(Cell cell : poison) {
            if((cell.getX() == x) && (cell.getY() == y)) return true;
        }
        return false;
    }

    public void add(){
        int x, y;
        do{
            x = random.nextInt(CANVAS_WIDTH);
            y = random.nextInt(CANVAS_HEIGHT);
        }while(snake.isInSnake(x, y)
                    || isPoison(x, y)
                    || food.isFood(x, y));
        poison.add(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.POISON_COLOR));
    }

    public void paint(Graphics2D graphics2D){
        for(Cell cell : poison){
            cell.paint(graphics2D);
        }
    }
}
