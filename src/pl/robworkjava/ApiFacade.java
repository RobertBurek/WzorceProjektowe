package pl.robworkjava;

import pl.robworkjava.database.EmployeeCreator;
import pl.robworkjava.database.EmployeeDatabase;
import pl.robworkjava.decorator.FreqBonus;
import pl.robworkjava.decorator.Payable;
import pl.robworkjava.decorator.SpecialBonus;
import pl.robworkjava.strategy.BikeTravelStrategy;
import pl.robworkjava.strategy.CarTravelStrategy;
import pl.robworkjava.strategy.Employee;
import pl.robworkjava.strategy.ManagerJobStrategy;

/**
 * Created by Robert Burek
 */
public class ApiFacade {

    //jeżeli mają być metody statyczne to tworzymy prywatny konstruktor bezargumentowy
    //wtedy nie da się zainstancjonować klasy w której chcemy pisać tylko statyczne metody
    //private ApiFacade(){}

    //Wystawianie API dla klienta, który nie musi wiedzieć jakie moduły zajmuja się konkretną funkcjalnością

    private EmployeeDatabase eDatabase = new EmployeeDatabase();
    private EmployeeCreator employeeCreator;


    public Employee createDoctor(int i) {
        employeeCreator = new EmployeeCreator();
        Employee doctor = employeeCreator.create(EmployeeCreator.BIKE_DOCTOR_SANDWICH);
        doctor.setSalary(i);
        eDatabase.addEmployee(doctor);
        return doctor;
    }

    public void pushDoctorToJob(Employee employee) {
        employee.goToWork();
        employee.doYourJob();
        employee.eatYourBreakfast(employee); //przekazałem Employee do metody i tam dałem mu sportStrategy

        employee.travelStrategy = new CarTravelStrategy();
        employee.goToWork();
        employee.jobStrategy = new ManagerJobStrategy();
        employee.doYourJob();
    }

    public int countSalary(Employee emp) {
        Payable employee = emp;
        if (emp.getSalary() > 8000) {
            employee = new SpecialBonus(employee);
        }
        if (emp.travelStrategy instanceof BikeTravelStrategy) {
            employee = new FreqBonus(employee);
        }

        return employee.getSalary();
    }

    public void giveFreeHouseToBestFreqEmployee(Employee emp) {
        House house = new House.HouseBuilder()
                .setAdress("ul. Szkolna 2")
                .setFloorsNumber(2)
                .setDoorsNumber(3)
                .setWindowsNumber(10)
                .build();
        System.out.println(emp.toString() + " dostaje dom " + house.toString());
    }
}
