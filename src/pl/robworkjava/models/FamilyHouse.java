package pl.robworkjava.models;

import pl.robworkjava.House;

/**
 * Created by Robert Burek
 */
public class FamilyHouse {

    String adress;
    Integer floorsNumber;

    public FamilyHouse(String adress, Integer floorsNumber) {
        this.adress = adress;
        this.floorsNumber = floorsNumber;
    }

    //statyczna metoda wytwórcza
    // z dwóch pól klasy House robimy nowy obiekt FamilyHouse
    public static FamilyHouse from(House house) {
        return new FamilyHouse(house.getAdress(), house.getFloorsNumber());
    }

    @Override
    public String toString() {
        return "FamilyHouse{" +
                "adress='" + adress + '\'' +
                ", floorsNumber=" + floorsNumber +
                '}';
    }
}
