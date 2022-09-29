package java1.lessonsforqa.lesson6;

public class Homezoo {
    public static void main(String[] args) {

        Dog sharik = new Dog("Шарик");
        System.out.printf("Забрали с приюта пса по имени %s\n", sharik.getName());
        Cat pushok = new Cat("Пушок");
        System.out.printf("Взяли в хорошие руки кота по имени %s\n", pushok.getName());
        Cat baitik = new Cat();
        System.out.println("Приютили бездомного кота");
        System.out.println("-------------------------------");

        System.out.println("Отвели новых друзей на соревнования для животных...");
        System.out.println("Итоги:");
        baitik.swim(50);
        sharik.swim(5);
        sharik.run(400);
        pushok.run(-10);
        System.out.println("-------------------------------");

        System.out.print("Количество котов: ");
        System.out.println(Cat.getCount());
        System.out.print("Количество собак: ");
        System.out.println(Dog.getCount());
        System.out.print("Общее количество зверей: ");
        System.out.println(Animal.getCount());
        System.out.print("Имя бездомного кота: ");
        System.out.println(baitik.getName());
    }
}
