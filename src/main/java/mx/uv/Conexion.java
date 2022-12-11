package mx.uv;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conexion {
    private static String driverName = "com.mysql.cj.jdbc.Driver";// com.mysql.cj.jdbc.Driver com.mysql.jdbc.Driver
    private static String url = "jdbc:mysql://containers-us-west-59.railway.app:7300/railway";
    private static String username = "root";
    private static String password = "uj27wZj76GWkvqlHTVfd";
    // private static String aceeso = (url + username + password);
    // variable de conexion
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            connection = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
            System.out.println("Error String");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver:" + e);
            System.out.println("Error de driver");
        }
        return connection;

    }
}
