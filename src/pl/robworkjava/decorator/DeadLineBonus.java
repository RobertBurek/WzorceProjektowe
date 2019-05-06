package pl.robworkjava.decorator;

/**
 * Created by Robert Burek
 */
public class DeadLineBonus extends Bonus {

    public DeadLineBonus(Payable payable) {
        super(payable);

    }

    @Override
    protected int getPaidBonus(int salary) {
        return (int)(salary*0.1f);
    }
}
