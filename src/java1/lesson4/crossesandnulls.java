package java1.lessonsforqa.lesson4;

import java.util.Scanner;

public class crossesandnulls {
    public static Scanner sc = new Scanner(System.in);
    public static boolean put = false;

    public static void main(String[] args) {
        int size;
        while (true) {
            System.out.println("Введите размер поля");
            size = sc.nextInt();
            if (size <= 2) {
                System.out.println("Число должно быть больше 2");
            } else {
                break;
            }
        }

        String[][] field = makeField(size);
        printField(field);

        //game loop
        while (true) {
            humanTurn(field);
            if (checkWin(field)) {
                break;
            }
            aiTurn(field);
            printField(field);
            if (checkWin(field)) {
                break;
            }
            if (!checkDraw(field)) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static String[][] makeField(int n) {
        String[][] field = new String[n][n];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "*";
            }
        }
        return field;
    }

    public static void printField(String[][] field) {
        System.out.println();
        for (int i = 0; i <= field.length; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < (field.length); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn(String[][] field) {
        String symbol = "X";
        int x, y;
        while (true) {
            System.out.println("Введите координаты в формате X Y, где X - номер строки, а Y - номер столбца");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            if (isCellValid(x, y, field, "X")) {
                break;
            }
        }
        field[x][y] = symbol;
    }

    public static boolean isCellValid(int x, int y, String[][] field, String s) {
        if (x < 0 || x >= field.length || y < 0 || y >= field.length) {
            System.out.println("Введеные координаты выходят за пределы игрового поля");
            System.out.println();
            return false;
        } else if (field[x][y] != "*") {
            if (s == "X") {
                System.out.println("Данное поле уже занято");
                System.out.println();
            }
            return false;
        }
        return true;
    }

    public static boolean checkWin(String[][] field) {
        int l = field.length;
        if (countRow(field, "O") == l || countCol(field, "O") == l || countLeftDia(field, "O") == l || countRightDia(field, "O") == l) {
            System.out.println("Вы проиграли, попробуйте еще раз");
            return true;

        // this should not ever happen, but anyway
        } else if (countRow(field, "X") == l || countCol(field, "X") == l || countLeftDia(field, "X") == l || countRightDia(field, "X") == l) {
            System.out.println("Ура! Вы выиграли");
            return true;
        }
        return false;
    }

    public static void aiTurn(String[][] field) {
        put = false;
        int numRowX = countRow(field, "X");
        int numColX = countCol(field, "X");
        int numLDiaX = countLeftDia(field, "X");
        int numRDiaX = countRightDia(field, "X");

        int numRowY = countRow(field, "O");
        int numColY = countCol(field, "O");
        int numLDiaY = countLeftDia(field, "O");
        int numRDiaY = countRightDia(field, "O");

        int maxX = getMax(field, numRowX, numColX, numLDiaX, numRDiaX);
        int maxY = getMax(field, numRowY, numColY, numLDiaY, numRDiaY);

        if (maxX >= maxY) {
            //defensive move
            if (maxX == numLDiaX) {
                putLeftDia(field);
            } else if (maxX == numRDiaX) {
                putRightDia(field);
            } else if (maxX == numRowX && maxX == numColX) {
                int posRow = maxRow(field, "X");
                int posCol = maxCol(field, "X");
                putRow(field, posRow, posCol);
            } else if (maxX == numRowX) {
                int posRow = maxRow(field, "X");
                putRow(field, posRow, posRow);
            } else if (maxX == numColX) {
                int posCol = maxCol(field, "X");
                putCol(field, posCol, posCol);
            } else {
                putLeftDia(field);
            }
        } else {
            //offensive move
            if (maxY == numLDiaY) {
                putLeftDia(field);
            } else if (maxY == numRDiaY) {
                putRightDia(field);
            } else if (maxY == numRowY && maxY == numColY) {
                int posRow = maxRow(field, "O");
                int posCol = maxCol(field, "O");
                putRow(field, posRow, posCol);
            } else if (maxY == numRowY) {
                int posRow = maxRow(field, "O");
                putRow(field, posRow, posRow);
            } else if (maxY == numColY) {
                int posCol = maxCol(field, "O");
                putCol(field, posCol, posCol);
            } else {
                putLeftDia(field);
            }
        }

        if (put) {
            return;
        } else {
            putAny(field);
            return;
        }
    }

    public static int countRow(String[][] field, String s) {
        int count = 0;
        for (int i = 0; i < (field.length); i++) {
            int tmp = 0;
            boolean symbol1 = false;
            boolean symbol2 = false;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == s) {
                    tmp++;
                }
                if (field[i][j] == "X") {
                    symbol1 = true;
                }
                if (field[i][j] == "O") {
                    symbol2 = true;
                }
            }
            if (symbol1 && symbol2) {
                continue;
            }
            if (tmp > count) {
                count = tmp;
            }
        }
        return count;
    }

    public static int maxRow(String[][] field, String s) {
        int row = 0;
        int count = 0;
        for (int i = 0; i < (field.length); i++) {
            int tmp = 0;
            boolean symbol1 = false;
            boolean symbol2 = false;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == s) {
                    tmp++;
                }
                if (field[i][j] == "X") {
                    symbol1 = true;
                }
                if (field[i][j] == "O") {
                    symbol2 = true;
                }
            }
            if (symbol1 && symbol2) {
                continue;
            }
            if (tmp > count) {
                count = tmp;
                row = i;
            }
        }
        return row;
    }

    public static int countCol(String[][] field, String s) {
        int count = 0;

        for (int j = 0; j < (field.length); j++) {
            int tmp = 0;
            boolean symbol1 = false;
            boolean symbol2 = false;
            for (int i = 0; i < field[j].length; i++) {
                if (field[i][j] == s) {
                    tmp++;
                }
                if (field[i][j] == "X") {
                    symbol1 = true;
                }
                if (field[i][j] == "O") {
                    symbol2 = true;
                }
            }
            if (symbol1 && symbol2) {
                continue;
            }
            if (tmp > count) {
                count = tmp;
            }
        }
        return count;
    }

    public static int maxCol(String[][] field, String s) {
        int row = 0;
        int count = 0;

        for (int j = 0; j < (field.length); j++) {
            int tmp = 0;
            boolean symbol1 = false;
            boolean symbol2 = false;
            for (int i = 0; i < field[j].length; i++) {
                if (field[i][j] == s) {
                    tmp++;
                }
                if (field[i][j] == "X") {
                    symbol1 = true;
                }
                if (field[i][j] == "O") {
                    symbol2 = true;
                }
            }
            if (symbol1 && symbol2) {
                continue;
            }
            if (tmp > count) {
                count = tmp;
                row = j;
            }
        }
        return row;
    }

    public static int countLeftDia(String[][] field, String s) {
        int count = 0;
        boolean symbol1 = false;
        boolean symbol2 = false;

        for (int i = 0; i < (field.length); i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i == j) {
                    if (field[i][j] == s) {
                        count++;
                    }
                    if (field[i][j] == "X") {
                        symbol1 = true;
                    }
                    if (field[i][j] == "O") {
                        symbol2 = true;
                    }
                }
            }
        }
        if (symbol1 && symbol2) {
            count = 0;
        }
        return count;
    }

    public static int countRightDia(String[][] field, String s) {
        int count = 0;
        boolean symbol1 = false;
        boolean symbol2 = false;

        for (int i = 0; i < (field.length); i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == field[i].length - 1 - i) {
                    if (field[i][j] == s) {
                        count++;
                    }
                    if (field[i][j] == "X") {
                        symbol1 = true;
                    }
                    if (field[i][j] == "O") {
                        symbol2 = true;
                    }
                }
            }
        }
        if (symbol1 && symbol2) {
            count = 0;
        }
        return count;
    }

    public static void putLeftDia(String[][] field) {
        for (int i = 0; i < (field.length); i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i == j) {
                    if (isCellValid(i, j, field, "O")) {
                        field[i][j] = "O";
                        put = true;
                        return;
                    }
                }
            }
        }
    }

    public static void putRightDia(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == field[i].length - 1 - i) {
                    if (isCellValid(i, j, field, "O")) {
                        field[i][j] = "O";
                        put = true;
                        return;
                    }
                }
            }
        }
    }

    public static void putRow(String[][] field, int row, int col) {
        if (isCellValid(row, col, field, "O")) {
            field[row][col] = "O";
            put = true;
            return;
        }

        for (int j = 0; j < (field[row].length); j++) {
            if (isCellValid(row, j, field, "O")) {
                field[row][j] = "O";
                put = true;
                return;
            }
        }
    }

    public static void putCol(String[][] field, int row, int col) {
        if (isCellValid(row, col, field, "O")) {
            field[row][col] = "O";
            put = true;
            return;
        }

        for (int i = 0; i < (field.length); i++) {

            if (isCellValid(i, col, field, "O")) {
                field[i][col] = "O";
                put = true;
                return;
            }
        }
    }

    public static void putAny(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isCellValid(i, j, field, "O")) {
                    field[i][j] = "O";
                    put = true;
                    return;
                }
            }
        }
    }

    public static boolean checkDraw(String[][] field) {
        boolean symbol = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == "*") {
                    symbol = true;
                }
            }
        }
        if (symbol) {
            return true;
        }
        return false;
    }

    public static int getMax(String[][] field, int numRow, int numCol, int numLDia, int numRDia) {
        int[] arr = new int[4];
        arr[0] = numRow;
        arr[1] = numCol;
        arr[2] = numLDia;
        arr[3] = numRDia;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
