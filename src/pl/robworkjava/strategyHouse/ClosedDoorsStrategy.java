package pl.robworkjava.strategyHouse;

/**
 * Created by Robert Burek
 */
public class ClosedDoorsStrategy implements DoorsStrategy {
    @Override
    public void makeSomethingDoors() {
        System.out.println("Zamknąłem wszystkie drzwi");
    }
}
