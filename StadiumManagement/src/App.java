
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        String Url = "jdbc:mysql://localhost:3306/stadium_management";
        String username = "root";
        String password = "";

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection connection = DriverManager.getConnection(Url, username, password);

        if (connection != null) {
            System.out.println("Connected to the database!");
            connection.close();
        } else {
            System.out.println("Failed to connect to the database.");
        }}}
       
