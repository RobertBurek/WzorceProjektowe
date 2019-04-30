package pl.robworkjava;

/**
 * Created by Robert Burek
 */
public class OldHouse {

    private String adress;
    private Integer floorsNumber;
    private Integer doorsNumber;
    private Integer windowsNumber;

//  ręczne budowanie wzorca budowniczego
//  tworzymy konstruktor
    public OldHouse(String adress, Integer floorsNumber, Integer doorsNumber, Integer windowsNumber) {
        this.adress = adress;
        this.floorsNumber = floorsNumber;
        this.doorsNumber = doorsNumber;
        this.windowsNumber = windowsNumber;
    }

    public OldHouse() {
    }

    public OldHouse setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public OldHouse setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
        return this;
    }

    public OldHouse setDoorsNumber(Integer doorsNumber) {
        this.doorsNumber = doorsNumber;
        return this;
    }

    public OldHouse setWindowsNumber(Integer windowsNumber) {
        this.windowsNumber = windowsNumber;
        return this;
    }

    // tworzymy metode do wytworzenia danego obiektu createHouse lub buildHouse
    public OldHouse createHouse(){
        return new OldHouse(adress, floorsNumber, doorsNumber, windowsNumber);
    }

}
