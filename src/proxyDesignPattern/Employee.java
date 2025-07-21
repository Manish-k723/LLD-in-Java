package proxyDesignPattern;

public class Employee implements EmployeeInterface{
    @Override
    public void create(String client, EmployeeDto employee) {
        System.out.println("Employee created by "+ client);
    }

    @Override
    public void update(String client, EmployeeDto employee) {
        System.out.println("Employee updated by "+ client);
    }

    @Override
    public void delete(String client, EmployeeDto employee) {
        System.out.println("Employee deleted by "+ client);
    }
}
