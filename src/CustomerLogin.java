import java.sql.SQLException;
import java.util.Scanner;

public class CustomerLogin {
    Scanner in = new Scanner(System.in);

    public void start() throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        dataBase.print();
        CustomerInfo details = new CustomerInfo();
        details.checkForLogin();
    }

}



