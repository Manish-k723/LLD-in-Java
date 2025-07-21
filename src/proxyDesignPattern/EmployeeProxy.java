package proxyDesignPattern;

public class EmployeeProxy implements EmployeeInterface{
    EmployeeInterface employee;

    public EmployeeProxy(EmployeeInterface employee) {
        this.employee = employee;
    }

    @Override
    public void create(String client, EmployeeDto employee) {
        if(client.equals("admin")){
            this.employee.create(client, employee);
        }else{
            System.out.println("Access denied, Only admin can perform this action");
        }
    }

    @Override
    public void update(String client, EmployeeDto employee) {
        if(client.equals("admin")){
            this.employee.update(client, employee);
        }else{
            System.out.println("Access denied, Only admin can perform this action");
        }
    }

    @Override
    public void delete(String client, EmployeeDto employee) {
        if(client.equals("admin")){
            this.employee.delete(client, employee);
        }else{
            System.out.println("Access denied, Only admin can perform this action");
        }
    }
}
