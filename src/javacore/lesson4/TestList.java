package javacore.lesson4;

import java.util.Arrays;
import java.util.HashMap;

public class TestList {
    public static void main(String args[]){
        System.out.println("Task 1");
        System.out.println("______________________________________________________");
        String[] words = {"year", "apartment", "agency", "owner", "definition", "device",
                "equipment", "phone", "flight", "year", "apartment", "owner", "device", "device",
                    "equipment"};

        HashMap<String, Integer> map = new HashMap<> ();

        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        System.out.println("Task 2");
        System.out.println("______________________________________________________");
        PhoneBook book = new PhoneBook();
        book.add("Vasya", "8-701-987-87-45");
        book.add("Petya", "8-741-26-47-46");
        book.add("Vova", "8-341-477-57-41");
        book.add("Vova", "8-331-457-07-51");
        book.add("Vova", "8-241-467-57-25");

        System.out.printf("Vasya - %s\n", Arrays.toString(book.get("Vasya")));
        System.out.printf("Vova - %s\n", Arrays.toString(book.get("Vova")));
    }
}
