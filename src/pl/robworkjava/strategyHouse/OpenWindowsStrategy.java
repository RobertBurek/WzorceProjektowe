package pl.robworkjava.strategyHouse;

/**
 * Created by Robert Burek
 */
public class OpenWindowsStrategy implements WindowsStrategy {
    @Override
    public void makeWatsWindows() {
        System.out.println("Otworzyłem kilka okien");
    }
}
