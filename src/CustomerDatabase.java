import java.sql.*;

public class CustomerDatabase {
    public void update(String theaterName, String cosName, String cosEmail, String number) throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection con = DriverManager.getConnection(url, userName, password);
        String theatre = theaterName;
        String name = cosName;
        String email = cosEmail;
        String num = number;
        String query = "insert into userinfo values (?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, theatre);
        statement.setString(2, name);
        statement.setString(3, email);
        statement.setString(4, num);
        int count = statement.executeUpdate();
        System.out.println("Booking Confirmed" + count);
        statement.close();
        con.close();
    }

    public void printUser() throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        String query = "select * from userinfo;";
        ResultSet rs = st.executeQuery(query);
        //print the sql
        String userData;
        while (rs.next()) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            userData = "Selected Theatre :" + rs.getString(1) + " User Name: " + rs.getString(2) + " E-Mail " + rs.getString(3) + " Mobile Number " + rs.getString(4);
            System.out.println(userData);
        }
        st.close();
        con.close();
    }
}

