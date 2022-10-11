import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Welcome {
    CustomerLogin booking = new CustomerLogin();
    Admin login = new Admin();

    public void begin() throws SQLException, ClassNotFoundException {
        System.out.println("_________*__________*______________*______________*\n Welcome Press 1 for Booking \n Press 2 for Admin login ");
        Scanner in = new Scanner(System.in);
        byte input = 0;
        while (true) {
            try {
                input = in.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Please enter the numeric value");
                in.nextLine();
            }
            switch (input) {
                case 1:
                    booking.start();
                    break;
                case 2:
                    login.forAdmin();
                    break;
                default:
                    begin();
                    System.out.println("Please enter only given choice");
            }
        }
    }
}
