package pl.robworkjava.decoratorHouse;

import pl.robworkjava.House;

/**
 * Created by Robert Burek
 */
public class DrewnianeKawalki extends Kawalki {
    public DrewnianeKawalki(CzyDecorowac decorowac) {
        super(decorowac);
    }

    @Override
    protected String getKawalki(String decorator) {
        return decorator.length() + " wszędzie leży połamane drewno futryn ";
    }
}
