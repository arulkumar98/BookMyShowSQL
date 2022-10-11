import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class CustomerInfo {
    Scanner in = new Scanner(System.in);

    public void checkForLogin() throws SQLException, ClassNotFoundException {
        CustomerDatabase dataUpdate = new CustomerDatabase();
        System.out.println("Please Below details for booking");
        System.out.println("Theater ID");
        String id = in.next();
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
        String name = in.next();
        System.out.println("Entre the mobile number");
        String mobileNo = in.next();
        String num = "^\\d{10}$";
        while (!mobileNo.matches(num)) {
            System.out.println("Please enter the valid Mobile Number");
            mobileNo = in.next();
        }
        System.out.println("Entre E-Mail id");
        String email = in.next();
        String regex = "^(.+)@(.+)$";
        while (!email.matches(regex)) {
            System.out.println("Please enter the valid e-mail address");
            email = in.next();
        }
        dataUpdate.update(theaterName, name, email, mobileNo);
    }
}
