package java1.lesson8;

import java.util.Random;

import static java1.lesson8.GameSnake.*;

public class Food extends Cell{
    private Random random;
    private Snake snake;
    private Poison poison;

    public Food(Snake snake){
        super(-1, -1, GameSnake.CELL_SIZE, FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public boolean isFood(int x, int y){
        return (getX() == x) && (getY() == y);
    }

    public boolean isEaten() {
        return (getX() == -1);
    }

    public void eat(){

        set(-1, -1);
    }

    public void appear(){
        int x, y;
        do{
            x = random.nextInt(CANVAS_WIDTH);
            y = random.nextInt(CANVAS_HEIGHT);
        }while(snake.isInSnake(x, y)
                    || poison.isPoison(x, y));
        set(x, y);
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }
}
