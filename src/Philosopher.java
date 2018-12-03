
public class Philosopher extends Thread {

    private int philosopherNumber;
    private Waiter waiter;

    public Philosopher(int philosopherNumber, Waiter waiter) {
        this.philosopherNumber = philosopherNumber;
        this.waiter = waiter;
    }


    public void run() {

        while (true) {

            System.out.println("Philosopher " + (philosopherNumber + 1) + " Is thinking...");
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
            }
            //P - opuszczanie
            //V - podnoszenie
            if (waiter.getPermission(waiter.getNumberOfFreeKnive(), waiter.getNumberOfFreeFork())) {
                int forkNumber = waiter.getNumberOfFreeFork();
                int kniveNumber = waiter.getNumberOfFreeKnive();

                waiter.getForks()[forkNumber].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking a fork " + (forkNumber+1) + " up");
                try {
                    Thread.sleep((int) (Math.random() + 100));
                } catch (InterruptedException e) {
                }

                waiter.getKnives()[kniveNumber].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking up a knive " + (kniveNumber+1) + " up");
                System.out.println("Philosopher" + (philosopherNumber + 1) + " is eating...");

                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a fork " + (forkNumber+1) + " down");
                waiter.getForks()[forkNumber].V();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a knive " + (kniveNumber+1) + " down");
                waiter.getKnives()[kniveNumber].V();
            }

        }


    }

}
