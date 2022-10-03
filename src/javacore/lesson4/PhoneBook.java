package javacore.lesson4;

import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {
    private HashMap<String, LinkedList<String>> book = new HashMap<>();

    public void add(String surName, String phone) {
        if (!book.containsKey(surName)) {
            LinkedList<String> list = new LinkedList<>();
            list.addLast(phone);
            book.put(surName, list);
        } else {
            LinkedList<String> list = book.get(surName);
            list.addLast(phone);
        }
    }

    public String[] get(String s) {
        if (!book.containsKey(s)) {
            System.out.println("This name does not exist");
            return new String[0];
        } else {
            LinkedList<String> list = book.get(s);
            return book.get(s).toArray(new String[list.size()]);
        }
    }
}
