package pl.robworkjava.strategyHouse;

/**
 * Created by Robert Burek
 */
public class CloseWinkowsStrategy implements WindowsStrategy {
    @Override
    public void makeWatsWindows() {
        System.out.println("Zamknąłem wszystkie okna");
    }
}
