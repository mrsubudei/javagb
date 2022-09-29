package javacore.lesson3.task1;

public class CheckGeneric {
    public static void main(String[] args) {
        MyClass<Integer> arr = new MyClass<Integer>(1, 2);

        System.out.println("Before: ");
        for (int i = 0; i < arr.checkArrLength(); i++) {
            System.out.print(arr.getElement(i));
            System.out.print(" ");
        }
        System.out.println();

        if (arr.checkArrLength() != 2) {
            System.out.println("only 2 length arrays is allowed");
            return;
        }

        arr.changeElements();
        System.out.println("After: ");
        for (int i = 0; i < arr.checkArrLength(); i++) {
            System.out.print(arr.getElement(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
