package pl.robworkjava;

/**
 * Created by Robert Burek
 */
public class NewHouse {

    private String adress;
    private Integer floorsNumber;
    private Integer doorsNumber;
    private Integer windowsNumber;

    // 1  tworzymy konstruktor z polami
    private NewHouse(String adress, Integer floorsNumber, Integer doorsNumber, Integer windowsNumber) {
        this.adress = adress;
        this.floorsNumber = floorsNumber;
        this.doorsNumber = doorsNumber;
        this.windowsNumber = windowsNumber;
    }

    // 2 Ctrl+Shift+A - builder i Intellij buduje potrzebne metody w nowej klasie NewHouseBuilder
    
    // 3 całą zawartość nowej klasy NewHouseBuilder przenosimy/kopiujemy do tej klasy jako klasę wewnętrzną poniżej
    public static class NewHouseBuilder {
        private String adress;
        private Integer floorsNumber;
        private Integer doorsNumber;
        private Integer windowsNumber;

        public NewHouseBuilder setAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public NewHouseBuilder setFloorsNumber(Integer floorsNumber) {
            this.floorsNumber = floorsNumber;
            return this;
        }

        public NewHouseBuilder setDoorsNumber(Integer doorsNumber) {
            this.doorsNumber = doorsNumber;
            return this;
        }

        public NewHouseBuilder setWindowsNumber(Integer windowsNumber) {
            this.windowsNumber = windowsNumber;
            return this;
        }

        public NewHouse build() {
            return new NewHouse(adress, floorsNumber, doorsNumber, windowsNumber);
        }
    }

    // 4 usuwamy przypisania zrobione przez Intellij oraz całą osobną klasę NewHouseBuilder
    // 5 zmieniamy klasę NewHouse na private, a NewHouseBuilder robimy dodatkowo static
    // 6 zmieniamy nazwę metody createNewHouse() na build() zgodnie z konwencją

}
