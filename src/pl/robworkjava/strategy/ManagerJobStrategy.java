package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class ManagerJobStrategy implements JobStrategy {
    @Override
    public void doYourJob() {
        System.out.println("Zarządzam ludźmi");
    }
}
