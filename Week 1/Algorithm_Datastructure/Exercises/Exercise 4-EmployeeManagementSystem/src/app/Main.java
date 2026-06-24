package app;

import model.Employee;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService(5);

        service.addEmployee(new Employee(101, "Kaviya", "Developer", 50000));
        service.addEmployee(new Employee(102, "Arun", "Tester", 40000));
        service.addEmployee(new Employee(103, "Meena", "Manager", 80000));

        System.out.println("📋 All Employees:");
        service.displayEmployees();

        System.out.println("\n🔍 Searching Employee 102:");
        System.out.println(service.searchEmployee(102));

        System.out.println("\n❌ Deleting Employee 102");
        service.deleteEmployee(102);

        System.out.println("\n📋 After Deletion:");
        service.displayEmployees();
    }
}