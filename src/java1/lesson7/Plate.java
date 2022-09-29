package java1.lessonsforqa.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int foodRemain() {
        return food;
    }
}