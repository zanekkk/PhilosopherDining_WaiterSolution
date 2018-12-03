import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("How many knives ? ");
        int knivesNumber = scanner.nextInt();
        System.out.println("How many forks ? ");
        int forksNumber = scanner.nextInt();

        Chopstick[] knives = new Chopstick[knivesNumber];
        Chopstick[] forks = new Chopstick[forksNumber];

        for (int i = 0; i < knivesNumber; i++) {
            knives[i] = new Chopstick(1);
        }

        for (int i = 0; i < forksNumber; i++) {
            forks[i] = new Chopstick(1);
        }

        Waiter waiter = new Waiter(knives, forks);

        for (int i = 0; i < 5; i++) {
            Thread p = new Philosopher(i, waiter);
            p.start();
        }
    }
}
