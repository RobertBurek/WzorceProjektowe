package pl.robworkjava;

import pl.robworkjava.models.FamilyHouse;

public class Main {

    public static void main(String[] args) {

        //BUILDER  -----------------------------------------------------------------------------------------------
        //wzorzec budowniczy

        House firstHouse = new House.HouseBuilder()
                .setAdress("ul. Szkolna 2")
                .setFloorsNumber(2)
                .setDoorsNumber(3)
                .setWindowsNumber(10)
                .build();

        //STATYCZNE METODY WYTWÓRCZE ------------------------------------------------------------------------------
        // from, of, valueOf, instanceOf
        // tworzenie obiektu z innego obiektu np Boolean z boolean poprzez valueOf()
        boolean isTrue = true;
        Boolean.valueOf(isTrue);

        // wykorzystanie statycznej metody wytwórczej from którą sami stworzyliśmy
        FamilyHouse newFamilyHouse = FamilyHouse.from(firstHouse);

        System.out.println(newFamilyHouse);

    }
}
