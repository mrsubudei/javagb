package javacore.lesson1;

public class Team {
    private String name;
    private Member[] members = new Member[4];

    public Team(String str1, String str2, String str3, String str4, String str5) {
        this.name = str5;
        Member member1 = new Member(str1);
        Member member2 = new Member(str2);
        Member member3 = new Member(str3);
        Member member4 = new Member(str4);

        members[0] = member1;
        members[1] = member2;
        members[2] = member3;
        members[3] = member4;
    }

    public Team() {
        this.name = "team1";
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        Member member3 = new Member("member3");
        Member member4 = new Member("member4");

        members[0] = member1;
        members[1] = member2;
        members[2] = member3;
        members[3] = member4;
    }

    public Member[] getTeam() {
        return members;
    }

    public void showResults() {
        System.out.printf("Результаты команды %s\n", name);
        for (Member m : members) {
            int i = 0;
            System.out.printf("Участник %s: ", m.getMemberName());
            System.out.printf("Сила - %d, ", m.getStrength());
            System.out.printf("Ловкость - %d, ", m.getDexterity());
            System.out.printf("Выносливость - %d, ", m.getVitality());
            System.out.printf("Интеллект - %d, \n", m.getIntelligence());
            System.out.print("Поднятие камня: ");
            printRes(m, i);
            i++;
            System.out.print("Сборка/разборка оружия: ");
            printRes(m, i);
            i++;
            System.out.print("Упражнение планка: ");
            printRes(m, i);
            i++;
            System.out.print("Спортивное ориентирование: ");
            printRes(m, i);
        }
    }

    public void printRes(Member m, int n) {
        boolean res = false;
        if (n == 0) {
            res = m.getChalOne();
        } else if (n == 1) {
            res = m.getChalTwo();
        } else if (n == 2) {
            res = m.getChalThree();
        } else if (n == 3) {
            res = m.getChalFour();
        }

        if (res) {
            System.out.println("Успех.");
        } else {
            System.out.println("Провал.");
        }
    }
}
