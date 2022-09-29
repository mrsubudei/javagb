package java1.lessonsforqa.lesson6;

import java.util.ArrayList;
import java.lang.*;
public class Animal
{
    private String name;
    protected static ArrayList<String> quantity = new ArrayList<String>();

    public Animal(String s) {
        this.name = s;
    }

    public Animal() {
        this.name = "зверь" + quantity.size();
    }

    public static int getCount() {
      return quantity.size();
    }


    public void run(int n) {
        System.out.println("Животное бежит");
    }

    public void swim(int n) {
        System.out.println("Животное плывет");
    }

    public String getName() {
        return name;
    }
}

