package java1.lesson5;

public class Employee {
    private String name;
    private String surName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String surName, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.surName = surName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String info() {
        String str1 = "name: " + this.name  + ", " + "surname: " + this.surName + ", ";
        String str2 = "position: " + this.position + ", " + "email: " + this.email + ", ";
        String str3 = "phone: " + this.phone + ", " + "salary: " + this.salary + ", " + "age: " + this.age;
        return  str1 + str2 + str3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
