package java1.lesson6;

public class Dog extends Animal {
    public Dog() {
        super("Пес" + Dog.getCount());
        quantity.add("dog");
    }

    public Dog(String s) {
        super(s);
        quantity.add("dog");
    }

    public static int getCount() {
        int dogCount = 0;

        for (String val : Animal.quantity) {
            if (val == "dog") {
                dogCount++;
            }
        }
        return dogCount;
    }

    @Override
    public void run(int n) {
        if (n > 500) {
            System.out.printf("%s не может столько бегать\n", getName());
        } else if (n <= 0) {
            System.out.printf("%s спит\n", getName());
        } else {
            System.out.printf("%s пробежал/а %d метров\n", getName(), n);
        }
    }

    @Override
    public void swim(int n) {
        if (n > 10) {
            System.out.printf("%s не может столько плыть\n", getName());
        } else if (n <= 0) {
            System.out.printf("%s сидит на берегу\n", getName());
        } else {
            System.out.printf("%s проплыл/а %d метров\n", getName(), n);
        }
    }
}