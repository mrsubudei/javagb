package javacore.lesson2;

public class TestExceptions {
    public static void checkArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        boolean wrong = false;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!isNumeric(arr[i][j])) {
                    int x = i + 1;
                    int y = j + 1;
                    throw new MyArrayDataException("Not integer at row: " +  x + " and col: " + y);
                }
                sum += Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println("The sum of given array is: " + sum);
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] myArrOne = new String[4][];
        String[] tmpOne1 = {"1568", "2345", "3234", "45"};
        String[] tmpOne2 = {"36", "264", "235", "125"};
        String[] tmpOne3 = {"194", "98", "3564", "4554"};
        String[] tmpOne4 = {"96442", "157", "987", "445"};
        myArrOne[0] = tmpOne1;
        myArrOne[1] = tmpOne2;
        myArrOne[2] = tmpOne3;
        myArrOne[3] = tmpOne4;

        try {
            checkArr(myArrOne);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] myArrTwo = new String[4][];
        String[] tmpTwo1 = {"1568", "2345", "324", "45"};
        String[] tmpTwo2 = {"36", "264", "235", "125"};
        String[] tmpTwo3 = {"194", "98", "34", "54"};
        String[] tmpTwo4 = {"96442", "1557", "445"};
        myArrTwo[0] = tmpTwo1;
        myArrTwo[1] = tmpTwo2;
        myArrTwo[2] = tmpTwo3;
        myArrTwo[3] = tmpTwo4;

        try {
            checkArr(myArrTwo);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] myArrThree = new String[4][];
        String[] tmpThree1 = {"1568", "2345", "3234", "45"};
        String[] tmpThree2 = {"36", "264", "235", "125"};
        String[] tmpThree3 = {"194", "98", "3b564", "4554"};
        String[] tmpThree4 = {"96442", "3454", "445", "2344"};
        myArrThree[0] = tmpThree1;
        myArrThree[1] = tmpThree2;
        myArrThree[2] = tmpThree3;
        myArrThree[3] = tmpThree4;

        try {
            checkArr(myArrThree);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
