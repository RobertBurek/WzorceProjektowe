package pl.robworkjava.decoratorHouse;

/**
 * Created by Robert Burek
 */
public class SzklaneKawalki extends Kawalki {

    public SzklaneKawalki(CzyDecorowac decorowac) {
        super(decorowac);
    }

    @Override
    protected String getKawalki(String decorator) {
        return decorator.length() + " wszędzie leżą kawałki szkła ";
    }

}
