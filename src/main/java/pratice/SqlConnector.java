package pratice;
import java.sql.*;
public class SqlConnector {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "root";
        String createDatabase = "create database DreamAxim;";
        String DropDatabase = "Drop database DreamAxim;";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement stm = con.createStatement();
            stm.executeUpdate(createDatabase);
            System.out.println("Created Database successfully");

        } catch (SQLException e) {
            System.out.println("Error");
        }
        finally {
            assert con != null;
            con.createStatement().executeUpdate(DropDatabase);
            con.close();
        }
    }
}