package pl.robworkjava.decoratorHouse;

/**
 * Created by Robert Burek
 */
public class MurKawalki extends Kawalki {
    public MurKawalki(CzyDecorowac decorowac) {
        super(decorowac);
    }

    @Override
    protected String getKawalki(String decorator) {
        return decorator.length() + " popękane mury ścian ";
    }
}
