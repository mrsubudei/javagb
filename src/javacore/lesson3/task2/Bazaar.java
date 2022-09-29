package javacore.lesson3.task2;

public class Bazaar {
    public static void main(String[] args) {
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Orange> boxOfOranges = new Box<Orange>(orange1);
        boxOfOranges.addFruits(orange2);
        System.out.println("Creating box of oranges");
        System.out.println("boxOfOranges weights: " + boxOfOranges.getWeight() + " kilo");

        Apple apple1 = new Apple();
        System.out.println("this will cause an error - boxOfOrange.addFruits(apple1); because of different types");

        Apple[] appleArr = new Apple[4];
        appleArr[0] = apple1;
        appleArr[1] = new Apple();
        appleArr[2] = new Apple();
        System.out.println("Creating box of apples");

        Box<Apple> boxOfApples = new Box<Apple>(appleArr);
        System.out.println("boxOfApples weights: " + boxOfApples.getWeight() + " kilo");
        System.out.println("Comparing two boxes..");
        System.out.println("result: " + boxOfOranges.compare(boxOfApples));
        System.out.println("adding fruits to boxOfApples");

        boxOfApples.addFruits(apple1);
        System.out.println("Comparing two boxes..");
        System.out.println("result: " + boxOfOranges.compare(boxOfApples));
        System.out.println("Creating another box of oranges");

        Box<Orange> boxOfOranges2 = new Box<Orange>(orange1);
        System.out.println("boxOfOranges2 weights: " + boxOfOranges2.getWeight() + " kilo");
        System.out.println("Transfering fruits from boxOfOranges1 to boxOfOranges2");

        boxOfOranges.transfer(boxOfOranges2);
        System.out.println("boxOfOranges weights: " + boxOfOranges.getWeight() + " kilo");
        System.out.println("boxOfOranges2 weights: " + boxOfOranges2.getWeight() + " kilo");

        System.out.println("this will cause an error - boxOfOranges.transfer(boxOfApples); because of different types");
    }
}
