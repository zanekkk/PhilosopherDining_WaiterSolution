public class Waiter {
    Chopstick[] knives;
    Chopstick[] forks;


    public Waiter(Chopstick[] knives, Chopstick[] forks) {
        this.knives = knives;
        this.forks = forks;
    }


    public Chopstick[] getKnives() {
        return knives;
    }

    public Chopstick[] getForks() {
        return forks;
    }

    public int getNumberOfFreeFork() {
        int number = -1;
        for (int i = 0; i < forks.length; i++) {
            if (forks[i].getValue() > 0) {
                number = i;
                return number;
            }
        }
        return number;
    }

    public int getNumberOfFreeKnive() {
        int number = -1;
        for (int i = 0; i < knives.length; i++) {
            if (knives[i].getValue() > 0) {
                number = i;
                return number;
            }
        }
        return number;
    }

    public boolean getPermission(int kniveNumber, int forkNumber) {
        if (kniveNumber > -1 && forkNumber > -1) {
            if (knives[kniveNumber].getValue() > 0 && forks[forkNumber].getValue() > 0) {
                return true;
            }
        }
        return false;
    }
}
