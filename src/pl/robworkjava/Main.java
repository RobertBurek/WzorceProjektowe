package pl.robworkjava;

public class Main {

    public static void main(String[] args) {
	    //wzorzec budowniczy
        new OldHouse("ul. Kursowa 2", 2, 3, 12);

        // max 3 argumenty w metodzie/konstruktorze jeżeli są różne
        // budowanie poprzez setery - wzorzec budowniczego
        // new House .setAdress .setFloorsNumber . setDoorsNumber . setWindowsNumber

        //settery zwracające House dają możliwość zmutowania instacji danej klasy House
        OldHouse fristHouse = new OldHouse()
                .setAdress("ul. Szkolna 2")
                .setDoorsNumber(3)
                .setWindowsNumber(10)
                .createHouse();

        // brak możliwości stworzenia instancji bezpośredniej gdyż konstruktor jest prywatny
        //new NewHouse("ul. Kursowa 2", 2, 3, 12);

        // nowa instancja klasy NewHouse
         NewHouse twoHouse = new NewHouse.NewHouseBuilder()
                .setAdress("ul. Szkolna 2")
                .setFloorsNumber(2)
                .setDoorsNumber(3)
                .setWindowsNumber(10)
                .build();

    }
}
