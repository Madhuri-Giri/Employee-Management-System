package employeemanagement;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBUtil dBUtil = new DBUtil();

        System.out.println("\n\t\t\tWelcome to Employee Management System\n");

        OUTER:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter 1 for add employee");
            System.out.println("Enter 2 for get employee");
            System.out.println("Enter 3 for delete employee");
            System.out.println("Enter other key for exit");
            System.out.print("\nEnter Value = ");
            int x = sc.nextInt();
            sc.nextLine();
            System.out.println(x);
            switch (x) {
                case 1:
                    dBUtil.addEmployee();
                    break;
                case 2:
                    dBUtil.getEmployee();
                    break;
                case 3:
                    dBUtil.deleteEmployee();
                    break;
                default:
                    System.out.println("\n\t\t\tThanks for using Employee Management System\n");
                    break OUTER;
            }
        }
    }
}
