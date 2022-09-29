package java1.lessonsforqa.lesson3;

import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {
        System.out.println("first task:");
        reverse();
        System.out.println("___________________________________");
        System.out.println("second task:");
        createIntArr();
        System.out.println("___________________________________");
        System.out.println("third task:");
        multiply();
        System.out.println("___________________________________");
        System.out.println("fourth task:");
        squareArr(5);
        System.out.println("___________________________________");
        System.out.println("fifth task:");
        printIntArr(createGivenArr(5, 2));
        System.out.println("___________________________________");
        System.out.println("sixth task:");
        findMinAndMax();
        System.out.println("___________________________________");
        System.out.println("seventh task:");
        int[] numbs = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(numbs));
        int[] numbs2 = {2, 2, 2, 1, 2, 2, 18, 1};
        System.out.println(checkBalance(numbs2));
        System.out.println("___________________________________");
        System.out.println("eighth task:");
        int[] numbs3 = {3, 5, 6, 1};
        moveArr(numbs3, 2);
        int[] numbs4 = {3, 5, 6, 1, 7, 8};
        moveArr(numbs4, -3);
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ ...
    public static void reverse() {
        int[] nums = {1, 0, 1, 1, 0, 1, 0, 1, 1, 0};
        System.out.print("Before: ");
        printIntArr(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else if (nums[i] == 0) {
                nums[i] = 1;
            }
        }
        System.out.print("After:  ");
        printIntArr(nums);
    }

    //2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить...
    public static void createIntArr() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        printIntArr(nums);
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему цик...
    public static void multiply() {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Before: ");
        printIntArr(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] *= 2;
            }
        }
        System.out.print("After:  ");
        printIntArr(nums);
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и ст...
    public static void squareArr(int n) {
        if (n <= 0) {
            System.out.println("The argument must be positive integer");
            return;
        }
        int[][] table = new int[n][n];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == j || j == table[i].length - 1 - i) {
                    table[i][j] = 1;
                }
            }
        }

        for (int[] ints : table) {
            for (int val : ints) {
                System.out.print(val);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и...
    public static int[] createGivenArr(int len, int initialValue) {
        if (len <= 0) {
            return new int[0];
        }
        int[] table = new int[len];
        for (int i = 0; i < table.length; i++) {
            table[i] = initialValue;
        }
        return table;
    }

    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элем...
    public static void findMinAndMax() {
        int[] table = new int[30];
        Random rand = new Random();
        for (int i = 0; i < table.length; i++) {
            table[i] = rand.nextInt(100);
        }

        int min = table[0];
        int max = table[0];
        for (int i = 1; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
            }
            if (table[i] < min) {
                min = table[i];
            }
        }
        System.out.print("given array: ");
        printIntArr(table);
        System.out.printf("Minimum values is: %d, maximum value is: %d\n", min, max);
    }

    //7. ** Написать метод, в который передается не пустой одномерный целочисленны...
    public static boolean checkBalance(int[] arr) {
        int pos = 0;
        boolean balanced = false;

        for (int j = 0; j < arr.length; j++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i <= pos) {
                    sumLeft += arr[i];
                } else {
                    sumRight += arr[i];
                }
            }
            if (sumLeft == sumRight) {
                balanced = true;
                break;
            }
            pos++;
        }
        //printing ans
        System.out.print("Given array: ");
        printIntArr(arr);
        if (balanced) {
            for (int i = 0; i < arr.length; i++) {
                if (i < pos) {
                    System.out.print(arr[i]);
                    System.out.print("+");
                } else if (i == pos) {
                    System.out.print(arr[i]);
                    System.out.print(" = ");
                } else {
                    System.out.print(arr[i]);
                    if (i != arr.length - 1) {
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
            System.out.print("Balanced: ");
            return true;
        } else {
            System.out.print("Balanced: ");
            return false;
        }
    }

    //8. *** Написать метод, которому на вход подается одномерный массив и число n...
    public static void moveArr(int[] arr, int n) {
        System.out.print("Before: ");
        printIntArr(arr);
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
            System.out.printf("After moving --> %d times: ", n);
        } else if (n < 0) {
              n *= -1;
            for (int i = 0; i < n; i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
            System.out.printf("After moving <-- %d times: ", n);
        }
        printIntArr(arr);
    }

    //addition method
    public static void printIntArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
