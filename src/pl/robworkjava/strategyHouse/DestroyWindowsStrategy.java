package pl.robworkjava.strategyHouse;

/**
 * Created by Robert Burek
 */
public class DestroyWindowsStrategy implements WindowsStrategy {
    @Override
    public void makeWatsWindows() {
        System.out.println("Wybiłem kilka okien");
    }
}
