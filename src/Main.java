
public class Main {
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        Waiter waiter = new Waiter(chopsticks);
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick(1);
            Thread p = new Philosopher(i, waiter);
            p.start();
        }
    }

}
