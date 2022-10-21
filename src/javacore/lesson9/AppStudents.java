package javacore.lesson9;

import javacore.lesson9.enums.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppStudents {

    public static Course chemistry = new Course(Subject.CHEMISTRY);
    public static Course history = new Course(Subject.HISTORY);
    public static Course biology = new Course(Subject.BIOLOGY);
    public static Course technology = new Course(Subject.TECHNOLOGY);
    public static Course physical_education = new Course(Subject.PHYSICAL_EDUCATION);
    public static Course literature = new Course(Subject.LITERATURE);
    public static Course drawing = new Course(Subject.DRAWING);
    public static Course music = new Course(Subject.MUSIC);
    public static Course math = new Course(Subject.MATH);
    public static Course geometry = new Course(Subject.GEOMETRY);
    public static Course algebra = new Course(Subject.ALGEBRA);

    public static void main(String[] args) {
        List<Student> students = getListOfStudent();

        //1. Написать функцию, принимающую список Student и возвращающую список
        // уникальных курсов, на которые подписаны студенты.
        List<Course> uniqueCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());

        for (Course c : uniqueCourses) {
            System.out.println(c.getName());
        }

        System.out.println("________________");

        //2. Написать функцию, принимающую на вход список Student и возвращающую
        // список из трех самых любознательных (любознательность определяется количеством курсов).
        List<Student> mostCurios = students.stream()
                .sorted((student1,student2) -> student2.getCourses().size() - student1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList());

        for (Student s : mostCurios) {
            System.out.println(s.getName());
        }
        System.out.println("________________");

        //3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
        // которые посещают этот курс.
        Course courseParam = math;
        List<Student> visiting = students.stream()
                .filter(student -> student.getCourses().contains(courseParam))
                .collect(Collectors.toList());
        for (Student s : visiting) {
            System.out.println(s.getName());
        }
    }

    public static List<Student> getListOfStudent(){


        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Mike", new ArrayList<>(Arrays.asList(
                        chemistry,
                        history,
                        biology
                ))),
                new Student("Bill", new ArrayList<>(Arrays.asList(
                        chemistry,
                        history
                ))),
                new Student("Bob", new ArrayList<>(Arrays.asList(
                        technology,
                        physical_education,
                        literature,
                        drawing,
                        music,
                        biology,
                        math,
                        algebra,
                        chemistry,
                        geometry
                ))),
                new Student("Patrick", new ArrayList<>(Arrays.asList(
                        technology,
                        physical_education,
                        math
                ))),
                new Student("Buckethead", new ArrayList<>(Arrays.asList(
                        literature,
                        biology,
                        math
                ))),
                new Student("John5", new ArrayList<>(Arrays.asList(
                        technology,
                        drawing,
                        music,
                        math
                ))),
                new Student("Zakk", new ArrayList<>(Arrays.asList(
                        technology,
                        math,
                        algebra,
                        history,
                        geometry
                        )))
        ));
        return students;
    }


}
