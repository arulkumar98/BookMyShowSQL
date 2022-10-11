import java.sql.*;

public class DataBase {
    public void print() throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        String query = "select * from info;";
        ResultSet resultSet = statement.executeQuery(query);
        //print the sql
        String userData;
        while (resultSet.next()) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            userData = "ID " + resultSet.getInt(1) + " | " + resultSet.getString(2) + " | Now Showing  " + resultSet.getString(3) + " | " + resultSet.getString(4) + " Ticket Price Rs." + resultSet.getInt(5);
            System.out.println(userData);
        }
        statement.close();
        connection.close();
    }
}
