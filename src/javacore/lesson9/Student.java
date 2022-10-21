package javacore.lesson9;

import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

}
