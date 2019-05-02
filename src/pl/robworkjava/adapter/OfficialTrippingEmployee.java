package pl.robworkjava.adapter;

import pl.robworkjava.strategy.Employee;

/**
 * Created by Robert Burek
 */
public class OfficialTrippingEmployee {
    private Employee employee;

    public OfficialTrippingEmployee(Employee employee) {
        this.employee = employee;
    }

    public void goToClient() {
        employee.goToWork();
        System.out.println("  to client");
    }
}
