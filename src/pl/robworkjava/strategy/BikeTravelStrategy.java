package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class BikeTravelStrategy implements TravelStrategy {
    @Override
    public void goToWork() {
        System.out.println("Going by bike");
    }
}
