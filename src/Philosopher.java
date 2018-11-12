
public class Philosopher extends Thread{

    private int philosopherNumber;
//    private Chopstick[] chopsticks;
    private Waiter waiter;

    public Philosopher(int philosopherNumber, Waiter waiter){
        this.philosopherNumber = philosopherNumber;
        this.waiter = waiter;
    }


    public void run(){
        int numberOfSecondChopstick = (philosopherNumber + 1) % 5;

        while(true){

            System.out.println("Philosopher " + (philosopherNumber+1) + " Is thinking...");
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
            }
            //P - opuszczanie
            //V - podnoszenie
            if(waiter.getPermission(philosopherNumber)) {
                waiter.getChopsticks()[philosopherNumber].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking a chopstick " + (philosopherNumber + 1) + " up");
                try {
                    Thread.sleep((int) (Math.random() + 100));
                } catch (InterruptedException e) {
                }

                waiter.getChopsticks()[numberOfSecondChopstick].P();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is picking up a chopstick " + (numberOfSecondChopstick + 1) + " up");
                System.out.println("Philosopher" + (philosopherNumber + 1) + " is eating...");

                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a chopstick " + (numberOfSecondChopstick + 1) + " down");
                waiter.getChopsticks()[numberOfSecondChopstick].V();
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is putting a chopstick " + (philosopherNumber + 1) + " down");
                waiter.getChopsticks()[philosopherNumber].V();
            }

        }


    }

}
