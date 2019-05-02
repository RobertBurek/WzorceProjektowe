package pl.robworkjava.strategy;

/**
 * Created by Robert Burek
 */
public class BaskedBallSportStrategy implements SportStrategy {
    @Override
    public void makeSports() {
        System.out.println("Gram w koszykówkę");
    }
}
