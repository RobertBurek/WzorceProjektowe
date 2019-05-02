package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class WolkingSportStrategy implements SportStrategy {
    @Override
    public void makeSports() {
        System.out.println("Mój sport to spacer - spaceruję");
    }
}
