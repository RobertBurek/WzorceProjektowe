package pl.robworkjava.decoratorHouse;

/**
 * Created by Robert Burek
 */
public abstract class Kawalki implements CzyDecorowac {

    private CzyDecorowac dekorowany;

    Kawalki(CzyDecorowac dekorowany) {
        this.dekorowany = dekorowany;
    }

    @Override
    public String getDecorator() {
        return dekorowany.getDecorator()+getKawalki(dekorowany.getDecorator());
    }

    abstract protected String getKawalki(String decorator);

}
