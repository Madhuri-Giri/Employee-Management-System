package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBUtil {

    ResultSet rs = null;
    PreparedStatement psmt = null;
    Connection con = null;
    String query = null;

    public DBUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "My$ql12345");
    }

    public void addEmployee() throws SQLException {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("\nEnter Id of Employee = ");
        emp.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name of Employee = ");
        emp.setName(sc.nextLine());

        System.out.print("Enter Age of Employee = ");
        emp.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Salary of Employee = ");
        emp.setSalary(sc.nextDouble());
        sc.nextLine();

        query = "insert into employee value(?,?,?,?)";

        psmt = con.prepareStatement(query);

        psmt.setInt(1, emp.getId());
        psmt.setString(2, emp.getName());
        psmt.setInt(3, emp.getAge());
        psmt.setDouble(4, emp.getSalary());

        psmt.executeUpdate();

        System.out.println("\nBelow Employee Added Succesfully\n");
        System.out.println(emp);

        con.close();
    }

    public void getEmployee() throws SQLException {
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery("select * from employee");

        while (rs.next()) {
            System.out.println("\nEmployee Id = " + rs.getInt("id"));
            System.out.println("Employee Name = " + rs.getString("name"));
            System.out.println("Employee Age = " + rs.getInt("age"));
            System.out.println("Employee Salary = " + rs.getDouble("salary"));

            System.out.println("");
        }
    }

    void deleteEmployee() throws SQLException {

        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);

        query = "delete from employee where id = ?";
        psmt = con.prepareStatement(query);
        System.out.print("Enter Employee Id which you want to delete = ");
        psmt.setInt(1, sc.nextInt());
        sc.nextLine();
        psmt.executeUpdate();

        System.out.println("\nEmployee Deleted Successfully\n");
    }
}
