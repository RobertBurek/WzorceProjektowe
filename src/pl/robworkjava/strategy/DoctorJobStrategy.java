package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class DoctorJobStrategy implements JobStrategy {
    @Override
    public void doYourJob() {
        System.out.println("Cure people");
    }
}
