import java.sql.*;

public class DataBase {
    public void print() throws SQLException, ClassNotFoundException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        String query = "select * from info;";
        ResultSet rs = st.executeQuery(query);
        //print the sql
        String userData;
        while (rs.next()) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            userData = "ID " + rs.getInt(1) + " | " + rs.getString(2) + " | Now Showing  " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getInt(5);
            System.out.println(userData);
        }
        st.close();
        con.close();
    }


}
