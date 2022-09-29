package javacore.lesson1;

public class Quadrathlon {
    public static void main(String[] args) {
        Team team = new Team("Jack", "Nick", "Adam", "Chris", "Barbarians");
        Course c = new Course();
        c.doIt(team);
        team.showResults();
    }
}
