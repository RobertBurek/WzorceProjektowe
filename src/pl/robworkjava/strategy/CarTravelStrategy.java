package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class CarTravelStrategy implements TravelStrategy {
    @Override
    public void goToWork() {
        System.out.println("Go by car");
    }
}
