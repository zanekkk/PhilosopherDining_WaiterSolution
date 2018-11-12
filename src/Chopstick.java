
public class Chopstick {
    private boolean taken = false;

    private int value;
    public Chopstick() {
        value = 0;
    }
    public Chopstick(int v) {
        value = v;
    }
    public synchronized void P() {//opuszczanie
        while (value <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        value--;

    }
    public synchronized void V(){//podnoszenie
        ++value;
        notify();
    }

    public int getValue() {
        return value;
    }
}
