package java1.lessonsforqa.lesson2;

public class HomeWork2 {

    public static boolean checkRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println("This number is positive");
        } else {
            System.out.println("This number is negative");
        }
    }

    public static boolean isNegative(int a) {
        return a >= 0;
    }

    public static void printStr(String str, int n) {
       for (int i = 0; i < n; i++) {
           System.out.println(str);
       }
    }

    public static boolean isLeapYear(int n) {
        return (n % 400 == 0) || (n % 4 == 0 && n % 100 != 0);
    }
}
