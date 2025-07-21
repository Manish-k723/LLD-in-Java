package proxyDesignPattern;

public interface EmployeeInterface {
    void create(String client, EmployeeDto employee);
    void update(String client, EmployeeDto employee);
    void delete(String client, EmployeeDto employee);
}
