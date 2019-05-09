package pl.robworkjava;

import pl.robworkjava.adapter.OfficialTrippingEmployee;
import pl.robworkjava.decorator.*;
import pl.robworkjava.decoratorHouse.CzyDecorowac;
import pl.robworkjava.decoratorHouse.DrewnianeKawalki;
import pl.robworkjava.decoratorHouse.MurKawalki;
import pl.robworkjava.decoratorHouse.SzklaneKawalki;
import pl.robworkjava.models.FamilyHouse;
import pl.robworkjava.observers.ObservableTempValue;
import pl.robworkjava.strategy.*;
import pl.robworkjava.strategyHouse.*;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //creationPatterns();
        //observerPattern();


        //STRATEGIA -----------------------------------------------------------------------------------
        //strategia zastępuje enuma lub switch case z logiką - klasami strategii
        //rozsprzęganie odpowiedzialnosci zamiast switcha

        //tworzymy klasę Employee z implementacjami interfejsów które zarazem są polami tej klasy
        //mamy pole jobStrategy typu interfejsowego JobStrategy
        //interfejs JobStrategy ma metodę doYourJob, która będzie nadpisywana w odpowiednich klasach
        //nastepnie tworzymy potrzebne klasy wykonywanej pracy np DoctorJobStrategy, ManagerJobStrategy
        //klasy te implementują odpowiedni interfejs z metodą do wykonania doYourJob()
        //w tej metodzie (np doYourJob) umieszczamy odpowiedni kod funkcyjne dla danej czynności

        Employee mike = new Employee();

        mike.travelStrategy = new BikeTravelStrategy();
        mike.jobStrategy = new DoctorJobStrategy();
        mike.sportstrategy = new WolkingSportStrategy();
        mike.makeSports();
        mike.breakfastStrategy = new SandwichBreakfastStrategy();

        mike.goToWork();
        mike.doYourJob();
        mike.eatYourBreakfast(mike); //przekazałem Employee do metody i tam dałem mu sportStrategy

        mike.travelStrategy = new CarTravelStrategy();
        mike.goToWork();
        mike.jobStrategy = new ManagerJobStrategy();
        mike.doYourJob();

        Thread.sleep(1000);
//        mike.sportstrategy = new BaskedBallSportStrategy();
        mike.makeSports();


        System.out.println("------------------------------ADAPTER---------------------------------------------------");

        //ADAPTER
        // .travel -> goToWork()
        //rozszerzamy funkcjonalność mike nie zmieniając jego klasy
        //tworzymy dodatkową klasę z polem poszerzanej klasy oraz metodę poszerzającą
        OfficialTrippingEmployee otMike = new OfficialTrippingEmployee(mike);
        otMike.goToClient();

        System.out.println("------------------------------DEKORATOR-------------------------------------------------");
        mike.setSalary(10000);


        //DEKORATOR
        //możemy dodawać kolejne ozdobniki bez względu na kolejność
        //wymagany jest interfejs łączący - Payable oraz klasy odpowiadające ozdobnikom (dekorartorom)
        //klasa Bonus sbstarkcyjna łacząca zliczająca ozdobniki (bonusy)
        System.out.println("Zarobki podstawowe:  " + mike.getSalary());
        System.out.println("Zarobki z premią: " + new FreqBonus(new DeadLineBonus(new SpecialBonus(mike))).getSalary());

        Payable employee = mike;
        if (mike.getSalary() > 8000) {
            employee = new SpecialBonus(employee);
        }
        if (mike.travelStrategy instanceof BikeTravelStrategy) {
            employee = new FreqBonus(employee);
        }

        System.out.println("Zarobki employee:  " + employee.getSalary());


        System.out.println("--------------------------------------------FASADA-------------------------------------");
        //FASADA -------------------------------------------------------------------------------------
        //najprostsza fasada to odelegowanie części czynności do osobnej medoty na przykład
        //tworzymy metodę jednemu z pracowników dajemy wolny dom w nagrodę i losowo.
        //bardziej rozbudowana fasada będzie w samej metodzie
        //osobna klasa ApiFacade wraz z rozbitymi metodami wewnetrznymi

        ApiFacade facade = new ApiFacade(); //prosta instancja
        Employee robin = facade.createDoctor(9245);
        facade.pushDoctorToJob(robin);
        facade.countSalary(robin);
        System.out.println("Wypłata: " + facade.countSalary(robin));
        facade.giveFreeHouseToBestFreqEmployee(robin);

    }


    private static void observerPattern() throws InterruptedException {
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
            if ((temp >= 3) || (temp <= -3)) break;
        }
    }


    private static void creationPatterns() throws InterruptedException {
        //BUILDER  -----------------------------------------------------------------------------------------------
        //wzorzec budowniczy

        House firstHouse = new House.HouseBuilder()
                .setAdress("ul. Szkolna 2")
                .setFloorsNumber(2)
                .setDoorsNumber(3)
                .setWindowsNumber(10)
                .build();

        // zastosuję wzorzec czynnościowy - Strategia (związany z oknami)
        firstHouse.windowsStrategy = new OpenWindowsStrategy();
        firstHouse.makeWatsWindows();
        Thread.sleep(2000);
        firstHouse.windowsStrategy = new DestroyWindowsStrategy();
        firstHouse.makeWatsWindows();
        Thread.sleep(2000);
//        firstHouse.windowsStrategy = new CloseWinkowsStrategy();
//        firstHouse.makeWatsWindows();
//        Thread.sleep(2000);
        // strategia związana z drzwiami
        firstHouse.doorsStrategy = new OpenDoorsStrategy();
        firstHouse.makeSomethingDoors();
        Thread.sleep(3000);
        firstHouse.doorsStrategy = new BrokenDoorsStrategy();
        firstHouse.makeSomethingDoors();
        Thread.sleep(3000);
//        firstHouse.doorsStrategy = new ClosedDoorsStrategy();
//        firstHouse.makeSomethingDoors();
//        Thread.sleep(3000);

        System.out.println("------------------------------------------DECORATOR na HOUSE -------------------------");
        System.out.println("Przed udekorowaniem: " + firstHouse.getDecorator());
        System.out.println("Możliwe dekoracje: " + new MurKawalki(new SzklaneKawalki(new DrewnianeKawalki(firstHouse))).getDecorator());
        System.out.println("Możliwe inna kolejność: " + new DrewnianeKawalki(new SzklaneKawalki(new MurKawalki(firstHouse))).getDecorator());

        CzyDecorowac dekorowany = firstHouse;

        if (firstHouse.windowsStrategy instanceof DestroyWindowsStrategy) {
            dekorowany = new SzklaneKawalki(dekorowany);
        }
        if (firstHouse.doorsStrategy instanceof BrokenDoorsStrategy) {
            dekorowany = new DrewnianeKawalki(dekorowany);
        }

        if (dekorowany.getDecorator().length() > 70) {
            dekorowany = new MurKawalki(dekorowany);
        }

        System.out.println("Po udekorowanie: " + dekorowany.getDecorator());
        System.out.println("------------------------------------------DECORATOR na HOUSE ----END----------------");

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
