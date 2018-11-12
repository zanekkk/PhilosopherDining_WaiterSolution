//import java.util.LinkedList;
//
//public class Main {
//    private int value;
//
//    public Main() {
//        value = 0;
//    }
//
//    public Main(int v) {
//        value = v;
//    }
//
//    public synchronized void P() { //try and decrease
//        while (value <= 0) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//            }
//            value--;
//        }
//    }
//
//    public synchronized void V() { //increase
//        ++value;
//        notify();
//    }
//}
//
//class DiningPhilosophers {
//
//    Main[] forks = new Main[5];
//
//    public void wykonaj() {
//
//        int i;
//        for (i = 0; i < 5; i++) {
//            forks[i] = new Main(1);
//        }
//        for (i = 0; i < 5; i++) {
//            Thread p = new Philosopher(i, forks);
//            p.start();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Dinning philosophers probler ");
//        DiningPhilosophers table = new DiningPhilosophers();
//        table.wykonaj();
//    }
//}
//
//class Philosopher extends Thread {
//    int pn;
//    Main[] forks;
//
//    public Philosopher(int n, Main[] forks) {
//        pn = n;
//        this.forks = forks;
//    }
//
//    public void run() {
//        int pnl = (pn + 1) % 5;
//        while (true) {
//// Thinking
//            System.out.println("Philosopher " + pn + " Is thinking...");
//            try {
//                Thread.sleep((int) (Math.random() * 300));
//            } catch (InterruptedException e) {
//            }
//
//            forks[pn].P();
//            System.out.println("Philosopher " + pn + " is picking a fork " + pn + " up");
//            try {
//                Thread.sleep((int) (Math.random() + 100));
//            } catch (InterruptedException e) {
//            }
//
//            forks[pnl].P();
//            System.out.println("Philosopher " + pn + " is picking up a fork" + pnl + " up");
//            //Eating
//            System.out.println("Philosopher" + pn + "is eating...");
//
//            try {
//                Thread.sleep((int) (Math.random() * 100));
//            } catch (InterruptedException e) {
//            }
//            System.out.println("Philosopher " + pn + " putting a fork " + pnl + " down");
//            forks[pnl].V();
//            System.out.println("Philosopher " + pn + " is putting a forks " + pn + " down");
//            forks[pn].V();
//        }
//    }
//}
