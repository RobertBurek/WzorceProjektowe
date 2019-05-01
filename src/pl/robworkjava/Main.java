package pl.robworkjava;

import pl.robworkjava.models.FamilyHouse;
import pl.robworkjava.observers.ObservableTempValue;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        creationPatterns();

        //OBSERWATOR
        //obsługa interfejsu użytkownika, kliknięcie
        //obsługa zmian repozytorium, zmiana danych
        //obsługiwanie zmian czujników i sterowników

        // NA PEWNO NIE odpytujemy obiektu obserwowanego (timer)
        //obiekt obserwowany powiadamia nas (obiekt obserwujący) o zmianie

        //deklaracja w miejscu obserwowania
        ObservableTempValue observableValue = new ObservableTempValue();

        //dodanie do listy oczekujących na informacje - pełny zapis
        observableValue.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if ((int) arg > 0) System.out.print(" dodatnia " + arg.toString());
            }
        });

        //dodanie do listy oczekujących na informacje - lambda
        observableValue.addObserver((o, arg) -> {
            if ((int) arg < 0) System.out.print(" ujemna " + arg.toString());
        });

        //metoda generująca zmienne wartości Temp
        GeneratorTemp(observableValue);

    }

    private static void GeneratorTemp(ObservableTempValue observableValue) throws InterruptedException {
        int temp = 0;
        while (true) {
            temp += Math.random() * 4 - 2;
            Thread.sleep(1000);
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            if (temp == 0) System.out.print(" zero " + temp);
            //obserwowanie wartości
            observableValue.setValue(temp);
        }
    }


    private static void creationPatterns() {
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

        //SINGLETON  -----------------------------------------------------------------------------------------------
        //nie wstrzykujemy, błędny kierunek
        //najlepiej się sprawdzają w logowaniu i  raportach w logach,
        //w repozytoriach i śledzenia ruchów użytkownika po aplikacji, do cacha do narzędzi śledzących,
        //do instancji bezstanowych przetrzymywanych przez cały czas działania programu
        LoggerOld.getInstance().logToConsole();

        Logger.getInstance().logToConsole();
    }
}
