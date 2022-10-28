import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    public void print() throws SQLException {
        //SQL Connection
        String url = "jdbc:mysql://localhost:3306/theatre";
        String userName = "root";
        String password = "245521";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        String query = "select * from info;";
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<Pojo> pojoArrayList = new ArrayList<>();
        while (resultSet.next()) {
            Pojo pojo = new Pojo();
            pojo.setTheatreId(resultSet.getInt(1));
            pojo.setTheatreName(resultSet.getString(2));
            pojo.setMovieName(resultSet.getString(3));
            pojo.setTech(resultSet.getString(4));
            pojo.setSeatCount(resultSet.getInt(5));
            pojoArrayList.add(pojo);

        }
        statement.close();
        connection.close();

        for (Pojo obj : pojoArrayList) {
            System.out.println("__________________________________________________________________________________________________________________________");
            System.out.println(" ID - " + obj.getTheatreId() + " " + obj.getTheatreName() +
                    "|| Now Showing " + obj.getMovieName() + "|| Enjoy with " + obj.getTech() + "|| Total seat " + obj.getSeatCount());
        }
    }
}
