package java1.lessonsforqa.lesson5;

public class EmployeeCaller {
    public static void main(String[] args) {
        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee("Sofia", "Mikhailova", "financial officer", "sofia789@gmail.com", "+7(789)684-89-78", 150000, 28);
        empArr[1] = new Employee("Marina", "Maksimova", "technology officer", "marina_maks@gmail.com", "+7(739)644-15-58", 170000, 33);
        empArr[2] = new Employee("Alisa", "Levova", "commercial officer", "levova123@mail.ru", "+7(756)344-57-18", 200000, 45);
        empArr[3] = new Employee("Eva", "Artemova", "chief audit executive", "artemova_eva@mail.ru", "+7(756)567-51-82", 250000, 22);
        empArr[4] = new Employee("Aleksandr", "Markov", "marketing officer", "alex777@mail.ru", "+7(745)527-56-17", 100000, 51);

        int count = 1;
        System.out.println("Employees over 40 are: ");
        for (int i=0; i < empArr.length; i++) {
            if (empArr[i].getAge() > 40) {
                System.out.print(count + ") ");
                System.out.println(empArr[i].info());
                count++;
            }
        }
    }
}
