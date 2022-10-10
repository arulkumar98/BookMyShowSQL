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
        String thName = in.next();
        System.out.println("Entre the movie Name");
        String movie = in.next();
        System.out.println("Entre the theatre Tech");
        String tech = in.next();
        System.out.println("Entre the Theatre Seat Count");
        int seat = in.nextInt();
        updateTheatre(id, thName, movie, tech, seat);
    }


    public void updateTheatre(int theaterId, String ThName, String movieName, String thTech, int seatCount) throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        int theaterIds = theaterId;
        String theatre = ThName;
        String movName = movieName;
        String tech = thTech;
        int setCot = seatCount;
        String query = "insert into info (?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, theaterIds);
        statement.setString(2, theatre);
        statement.setString(3, movName);
        statement.setString(4, tech);
        statement.setInt(5, setCot);
        int count = statement.executeUpdate();
        System.out.println("New Theater added " + count);
        statement.close();
        con.close();
    }
}
