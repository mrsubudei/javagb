package javacore.lesson1;

public class Challenge {
    private int requiredStr;
    private int requiredDex;
    private int requiredVit;
    private int requiredInt;

    public Challenge(int n1, int n2, int n3, int n4) {
        requiredStr = n1;
        requiredDex = n2;
        requiredVit = n3;
        requiredInt = n4;
    }

    public int getRequiredStr() {
        return requiredStr;
    }

    public int getRequiredDex() {
        return requiredDex;
    }

    public int getRequiredVit() {
        return requiredVit;
    }

    public int getRequiredInt() {
        return requiredInt;
    }

}
