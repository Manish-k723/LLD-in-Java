package proxyDesignPattern;

public class Client {
    public static void main(String[] args) {
        EmployeeInterface employee = new Employee();
        EmployeeInterface proxy = new EmployeeProxy(employee);

        proxy.create("admin", new EmployeeDto());
        proxy.update("client2", new EmployeeDto());
        proxy.delete("admin", new EmployeeDto());
    }
}
