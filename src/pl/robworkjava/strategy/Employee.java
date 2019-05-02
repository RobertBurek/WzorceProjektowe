package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class Employee implements TravelStrategy, JobStrategy, BreakfastStrategy, SportStrategy {

    public TravelStrategy travelStrategy;
    public JobStrategy jobStrategy;
    public BreakfastStrategy breakfastStrategy;
    public SportStrategy sportstrategy;

    @Override
    public void doYourJob() {
        jobStrategy.doYourJob();
    }

    @Override
    public void goToWork() {
        travelStrategy.goToWork();
    }

    @Override
    public void makeSports() {
        sportstrategy.makeSports();
    }

    @Override
    public void eatYourBreakfast(Employee employee) {
        breakfastStrategy.eatYourBreakfast(employee);
    }
}
