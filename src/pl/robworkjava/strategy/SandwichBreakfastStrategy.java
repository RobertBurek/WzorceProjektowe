package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class SandwichBreakfastStrategy implements BreakfastStrategy {
    @Override
    public void eatYourBreakfast(Employee employee) {
        employee.sportstrategy = new BaskedBallSportStrategy();
        System.out.println("Eat sandwich");
    }
}
