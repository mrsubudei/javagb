package javacore.lesson1;

import java.util.Random;

public class Course {
    private Random r = new Random();
    private Challenge[] chalArr = new Challenge[4];

    public Course() {
        Challenge liftStone = new Challenge(6, 1, 2, 1);
        Challenge weaponAssembly = new Challenge(2, 6, 1, 3);
        Challenge plankExercise = new Challenge(3, 1, 6, 2);
        Challenge orienteering = new Challenge(1, 1, 3, 6);

        chalArr[0] = liftStone;
        chalArr[1] = weaponAssembly;
        chalArr[2] = plankExercise;
        chalArr[3] = orienteering;
    }

    public void doIt(Team t) {
        for (Member m : t.getTeam()) {
            for (int i=0; i<4; i++) {
                participate(chalArr[i], m, i);
            }
        }
    }

    public void participate(Challenge c, Member m, int n) {
        int str = m.getStrength();
        int dex = m.getDexterity();
        int vit = m.getVitality();
        int intel = m.getIntelligence();

        int reqStr = c.getRequiredStr();
        int reqDex = c.getRequiredDex();
        int reqVit = c.getRequiredVit();
        int reqInt = c.getRequiredInt();

        if (n == 0) {
            if (r.nextInt(str) >= r.nextInt(reqStr) && r.nextInt(dex) >= r.nextInt(reqDex)) {
                m.setChalOne(true);
            }
        } else if (n == 1) {
            if (r.nextInt(dex) >= r.nextInt(reqDex) && r.nextInt(intel) >= r.nextInt(reqInt)) {
                m.setChalTwo(true);
            }
        } else if (n == 2) {
            if (r.nextInt(vit) >= r.nextInt(reqVit) && r.nextInt(str) >= r.nextInt(reqStr)) {
                m.setChalThree(true);
            }
        } else if (n == 3) {
            if (r.nextInt(intel) >= r.nextInt(reqInt) && r.nextInt(vit) >= r.nextInt(reqVit)) {
                m.setChalFour(true);
            }
        }

    }
}
