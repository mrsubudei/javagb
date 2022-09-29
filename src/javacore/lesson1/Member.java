package javacore.lesson1;

import java.util.Random;

public class Member {
    private Random r = new Random();
    private String memberName;

    private int strength = r.nextInt(10) + 1;
    private int dexterity = r.nextInt(10) + 1;
    private int vitality = r.nextInt(10) + 1;
    private int intelligence = r.nextInt(10) + 1;

    private boolean chalOnePassed;
    private boolean chalTwoPassed;
    private boolean chalThreePassed;
    private boolean chalFourPassed;

    public Member(String s) {
        this.memberName = s;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getVitality() {
        return vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public boolean getChalOne() {
        return chalOnePassed;
    }

    public void setChalOne(boolean b) {
        this.chalTwoPassed = b;
    }

    public boolean getChalTwo() {
        return chalTwoPassed;
    }

    public void setChalTwo(boolean b) {
        this.chalOnePassed = b;
    }

    public boolean getChalThree() {
        return chalThreePassed;
    }

    public void setChalThree(boolean b) {
        this.chalThreePassed = b;
    }

    public boolean getChalFour() {
        return chalFourPassed;
    }

    public void setChalFour(boolean b) {
        this.chalFourPassed = b;
    }
}
