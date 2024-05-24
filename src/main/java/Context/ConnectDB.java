package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return conn;
        }
    }

    public static void main(String[] args) {
        Connection conn = ConnectDB.getConnection();

        if (conn != null) {
            System.out.println("successful");
        } else {
            System.out.println("failed");
        }
    }
}
