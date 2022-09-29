package javacore.lesson3.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> arr = new ArrayList<T>();
    private final Apple appleEx = new Apple();
    private final Orange orangeEx = new Orange();
    private final double appleWeight = 0.125;
    private final double orangeWeight = 0.25;

    public Box(T el) {
        this.arr.add(el);
    }

    public Box(T[] ar) {
        ArrayList<T> tmp = new ArrayList<T>();
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                tmp.add(ar[i]);
            }
        }
        this.arr = tmp;
    }

    public double getWeight() {
        if (arr.size() == 0) {
            return 0.0;
        }
        if(arr.get(0).getClass() == appleEx.getClass()) {
            return (double)arr.size() * appleWeight;
        } else {
            return (double)arr.size() * orangeWeight;
        }
    }

    public void addFruits(T[] arrToAdd) {
        this.arr.addAll(Arrays.asList(arrToAdd));
    }

    public void addFruits(T el) {
        this.arr.add(el);
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> another) {
        for (int i = 0; i < arr.size(); i++) {
            another.arr.add(arr.get(i));
        }
        this.arr.clear();
    }
}