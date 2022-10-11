import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    DataBase data = new DataBase();
    CustomerDatabase details = new CustomerDatabase();
    Scanner in = new Scanner(System.in);

    public void forAdmin() throws SQLException, ClassNotFoundException {
        System.out.println("Enter User Name: ");
        String adminName = "admin";
        String userName = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        String pass = "12345";
        if (!password.equals(pass) || !userName.equals(adminName)) {
            System.out.println("Invalid Credentials ");
            forAdmin();
        } else {
            System.out.println("Enter 1 to Check the users booking info \n Enter 2 to Add a new table ");
            String input = in.next();
            if (Objects.equals(input, "1")) {
                details.printUser();
            } else if (Objects.equals(input, "2")) {
                AdminAccess add = new AdminAccess();
                add.addNew();
            } else {
                System.out.println("Access Denied");
                forAdmin();
            }
        }
    }
}

