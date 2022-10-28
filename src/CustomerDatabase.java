import java.sql.*;

public class CustomerDatabase {
    public void update(String theaterName, String customeName, String cosEmail, String number, String date) throws SQLException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection connection = DriverManager.getConnection(url, userName, password);
        String query = "insert into userinfo values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, theaterName);
        statement.setString(2, customeName);
        statement.setString(3, cosEmail);
        statement.setString(4, number);
        statement.setString(5, date);

        int count = statement.executeUpdate();
        System.out.println("Booking Confirmed" + count);
        statement.close();
        connection.close();
    }

    public void printUser() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        String query = "select * from userinfo;";
        ResultSet resultSet = statement.executeQuery(query);
        String userData;
        while (resultSet.next()) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            userData = "Selected Theatre: " + resultSet.getString(1) + "|  User Name: " +
                    resultSet.getString(2) + " | E-Mail: " + resultSet.getString(3) +
                    " | Mobile Number: " + resultSet.getString(4) + "Booked Date " + resultSet.getString(5);
            System.out.println(userData);
        }
        statement.close();
        connection.close();
    }
}

