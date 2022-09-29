package java1.lessonsforqa.lesson6;

public class Cat extends Animal {

    public Cat() {
        super("Кот" + Cat.getCount());
        quantity.add("cat");
    }

    public Cat(String s) {
       super(s);
       quantity.add("cat");
    }

    public static int getCount() {
        int catCount = 0;

        for (String val : Animal.quantity) {
            if (val == "cat") {
                catCount++;
            }
        }
        return catCount;
    }

    @Override
    public void run(int n) {
        if (n > 200) {
            System.out.printf("%s не может столько бегать\n", getName());
        } else if (n <= 0) {
            System.out.printf("%s спит\n",  getName());
        } else {
            System.out.printf("%s пробежал/а %d метров\n",  getName(), n);
        }
    }

    @Override
    public void swim(int n) {
        System.out.println("Коты не умеют плавать");
    }
}