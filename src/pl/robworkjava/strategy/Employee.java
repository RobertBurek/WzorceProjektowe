package pl.robworkjava.strategy;

import pl.robworkjava.decorator.Payable;

/**
 * Created by Robert Burek
 */
public class Employee implements TravelStrategy, JobStrategy, BreakfastStrategy, SportStrategy, Payable {

    private int salary = 0;

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

    @Override
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", travelStrategy=" + travelStrategy +
                ", jobStrategy=" + jobStrategy +
                ", breakfastStrategy=" + breakfastStrategy +
                '}';
    }
}
