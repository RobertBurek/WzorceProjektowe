package pl.robworkjava.database;

import pl.robworkjava.strategy.BikeTravelStrategy;
import pl.robworkjava.strategy.DoctorJobStrategy;
import pl.robworkjava.strategy.Employee;
import pl.robworkjava.strategy.SandwichBreakfastStrategy;

/**
 * Created by Robert Burek
 */
public class EmployeeCreator {

    public static final String BIKE_DOCTOR_SANDWICH = "bikeDoctorSandwich";

    public Employee create(String employeeType) {

        switch (employeeType) {
            case BIKE_DOCTOR_SANDWICH: {
                Employee doctor = new Employee();
                doctor.travelStrategy = new BikeTravelStrategy();
                doctor.jobStrategy = new DoctorJobStrategy();
                doctor.breakfastStrategy = new SandwichBreakfastStrategy();
                return doctor;
            }
            default:
                return new Employee();

        }
    }
}
