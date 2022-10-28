import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    CustomerDatabase details = new CustomerDatabase();
    Scanner scanner = new Scanner(System.in);

    public void forAdmin() throws SQLException, ClassNotFoundException {
        System.out.println("Enter User Name: ");
        String adminName = "admin";
        String userName = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        String pass = "12345";
        if (!password.equals(pass) || !userName.equals(adminName)) {
            System.out.println("Invalid Credentials ");
            forAdmin();
        } else {
            System.out.println(" Enter 1 to Check the users booking info \n Enter 2 to Add a Theater ");
            String input = scanner.next();
            if (Objects.equals(input, "1")) {
                details.printUser();
            } else if (Objects.equals(input, "2")) {
                AdminAccess add = new AdminAccess();
                add.addNew();
            } else {
                System.out.println("Access Denied");
            }
        }
    }
}

