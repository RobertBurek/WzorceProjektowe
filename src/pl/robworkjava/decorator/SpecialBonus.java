package pl.robworkjava.decorator;

/**
 * Created by Robert Burek
 */
public class SpecialBonus extends Bonus {
    public SpecialBonus(Payable payable) {
        super(payable);
    }

    @Override
    protected int getPaidBonus(int salary) {
        return 854;
    }
}
