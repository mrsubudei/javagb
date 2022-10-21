package javacore.lesson9;

import javacore.lesson9.enums.Subject;

public class Course {
    private Subject name;

    public Course(Subject name) {
        this.name = name;
    }

    public Subject getName() {
        return name;
    }

}
