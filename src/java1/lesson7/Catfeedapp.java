package java1.lessonsforqa.lesson7;

public class Catfeedapp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Murzik", 10);
        Cat cat3 = new Cat("Bobik", 15);
        Cat cat4 = new Cat("Chernish", 15);
        Cat cat5 = new Cat("Vasya", 10);
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};

        Plate plate = new Plate(50);

        feedCats(cats, plate);
        System.out.println("Проверяем всем ли хватило");
        int hungryCats = checkHungryCats(cats);
        if (hungryCats != 0) {
            System.out.println("Ох, еще есть голодные");
            while (hungryCats != 0) {
                System.out.println("Наполняем миску");
                plate.addFood(50);
                feedCats(cats, plate);
                hungryCats = checkHungryCats(cats);
            }
        }

        System.out.println("Наконец то все поели");
    }

    public static void feedCats(Cat[] cats, Plate plate) {
        System.out.println("Начинаем кормить котов...");
        for (Cat val : cats) {
            if (val.isHungry()) {
                val.eat(plate);
                System.out.printf("В миске осталось еды - %d\n", plate.foodRemain());
            }
        }
    }

    public static int checkHungryCats(Cat[] cats) {
        int numOfHungryCats = 0;
        for (Cat val : cats) {
            if (val.isHungry()) {
                numOfHungryCats++;
            }
        }
        return numOfHungryCats;
    }
}