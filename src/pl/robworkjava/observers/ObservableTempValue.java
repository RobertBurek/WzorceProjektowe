package pl.robworkjava.observers;

import java.util.Observable;

/**
 * Created by Robert Burek
 */
public class ObservableTempValue extends Observable {

    public void setValue(int newTemp) {
        if (newTemp != 0) {
            super.setChanged();
            super.notifyObservers(newTemp);
        }
    }
}

