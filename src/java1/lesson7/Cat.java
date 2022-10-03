package java1.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fed = false;
    }

    public void eat(Plate p) {
        if (p.foodRemain() - appetite < 0) {
            System.out.printf("Котику %s не хватает еды\n", name);
        } else {
            System.out.printf("Котик %s кушает\n", name);
            p.decreaseFood(appetite);
            fed = true;
        }
    }

    public boolean isHungry() {
        return !fed;
    }
}
