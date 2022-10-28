import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAccess {
    public void addNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please entre the following details carefully");
        System.out.println("Entre the Theatre ID");
        int theatreId = scanner.nextInt();
        System.out.println("Entre the theatre name ");
        String theatreName = scanner.next();
        System.out.println("Entre the movie Name");
        String movie = scanner.next();
        System.out.println("Entre the theatre Tech");
        String tech = scanner.next();
        System.out.println("Entre the Ticket Price");
        int price = scanner.nextInt();

        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "insert into info values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, theatreId);
            statement.setString(2, theatreName);
            statement.setString(3, movie);
            statement.setString(4, tech);
            statement.setInt(5, price);
            int count = statement.executeUpdate();
            System.out.println("New Theater added " + count);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}