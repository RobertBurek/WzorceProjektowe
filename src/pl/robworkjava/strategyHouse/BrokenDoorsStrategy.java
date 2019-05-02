package pl.robworkjava.strategyHouse;

/**
 * Created by Robert Burek
 */
public class BrokenDoorsStrategy implements DoorsStrategy {
    @Override
    public void makeSomethingDoors() {
        System.out.println("Wyłamałem kilka drzwi");
    }
}
