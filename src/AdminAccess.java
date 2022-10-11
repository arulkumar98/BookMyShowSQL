import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAccess {
    public void addNew() throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please entre the following details carefully");
        System.out.println("Entre the Theatre ID");
        int id = in.nextInt();
        System.out.println("Entre the theatre name ");
        String theatreName = in.next();
        System.out.println("Entre the movie Name");
        String movie = in.next();
        System.out.println("Entre the theatre Tech");
        String tech = in.next();
        System.out.println("Entre the Theatre Seat Count");
        int seat = in.nextInt();
        updateTheatre(id, theatreName, movie, tech, seat);
    }

    public void updateTheatre(int theaterId, String theaterName, String movieName, String theaterTech, int ticketfare) throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theaterName";
        String userName = "root";
        String password = "245521";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        int theatersIds = theaterId;
        String theatersName = theaterName;
        String moviesName = movieName;
        String theatersTech = theaterTech;
        int ticketPrice = ticketfare;
        String query = "insert into info (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, theatersIds);
        statement.setString(2, theatersName);
        statement.setString(3, moviesName);
        statement.setString(4, theatersTech);
        statement.setInt(5, ticketPrice);
        int count = statement.executeUpdate();
        System.out.println("New Theater added " + count);
        statement.close();
        connection.close();
    }
}
