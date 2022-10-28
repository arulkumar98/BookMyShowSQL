import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class CustomerInfo {
    Scanner scanner = new Scanner(System.in);

    public void checkForLogin() throws SQLException, ClassNotFoundException {
        CustomerDatabase dataUpdate = new CustomerDatabase();
        System.out.println("Please Below details for booking");
        System.out.println("Theater ID");
        String id = scanner.next();
        String theaterName = "";
        if (Objects.equals(id, "1")) {
            theaterName = "Pss Multiplex Tenkasi";
        } else if (Objects.equals(id, "2")) {
            theaterName = "SRI PADMAM CINEMAS Tenkasi";
        } else if (Objects.equals(id, "3")) {
            theaterName = "Sathyam Cinemas Chennai";
        } else {
            System.out.println("Please entre correct Theatre ID");
            checkForLogin();
        }
        System.out.println("Entre the Name");
        String name = scanner.next();
        System.out.println("Entre the mobile number");
        String mobileNo = scanner.next();
        String num = "^\\d{10}$";
        while (!mobileNo.matches(num)) {
            System.out.println("Please enter the valid Mobile Number");
            mobileNo = scanner.next();
        }
        System.out.println("Entre E-Mail id");
        String email = scanner.next();
        String regex = "^(.+)@(.+)$";
        while (!email.matches(regex)) {
            System.out.println("Please enter the valid e-mail address");
            email = scanner.next();
        }
        System.out.println("Enter the date in this format dd-mm-yyyy");
        String dateInput = scanner.next();
        dataUpdate.update(theaterName, name, email, mobileNo, dateInput);
    }
}
