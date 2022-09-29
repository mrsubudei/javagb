package java1.lesson1;

public class Test {
    public class HomeWorkApp {
        public static void main(String[] args) {
            printThreeWords();
            checkSumSign();
            printColor();
            compareNumbers();
        }

        public static void printThreeWords() {
            System.out.println("Orange1");
            System.out.println("Banana");
            System.out.println("Apple");
        }

        public static void checkSumSign() {
            int a = 1;
            int b = 2;
            if (a + b >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }
        }

        public static void printColor() {
            int value = 1;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (value > 0 && value <= 100) {
                System.out.println("Желтый");
            } else if (value > 100) {
                System.out.println("Зеленый");
            }
        }

        public static void compareNumbers() {
            int a = 5;
            int b = 15;
            if (a >= b) {
                System.out.println("a >= b");
            } else {
                System.out.println("a < b");
            }
        }
    }
}
