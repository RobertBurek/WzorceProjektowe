package pl.robworkjava.strategyHouse;

import pl.robworkjava.strategyHouse.DoorsStrategy;

/**
 * Created by Robert Burek
 */
public class OpenDoorsStrategy implements DoorsStrategy {
    @Override
    public void makeSomethingDoors() {
        System.out.println("Otworzyłem kilka drzwi");
    }
}
