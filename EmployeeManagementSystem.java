import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // Add Employee
    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, dept, salary));
        System.out.println("Employee added successfully!");
    }

    // Display Employees
    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("ID\tName\tDepartment\tSalary");
        for (Employee emp : employees) {
            emp.display();
        }
    }

    // Search Employee
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee found:");
                emp.display();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Update Salary
    static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new salary: ");
                double salary = sc.nextDouble();
                emp.setSalary(salary);
                System.out.println("Salary updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}

