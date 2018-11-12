public class Waiter {
    Chopstick[] chopsticks;

    public Waiter(Chopstick[] chopsticks){
        this.chopsticks = chopsticks;
    }


    public Chopstick[] getChopsticks() {
        return chopsticks;
    }


    public boolean getPermission(int firstChopstickNumber){
        int secondChopstickNumber = (firstChopstickNumber + 1) % 5;
        if(chopsticks[firstChopstickNumber].getValue() > 0 && chopsticks[secondChopstickNumber].getValue() > 0 ){
        return true;}
        return false;
    }
}
