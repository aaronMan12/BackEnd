package mx.uv;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "mysql://root:rgsd9O8LdB5YZZVqHaah@containers-us-west-59.railway.app:7300/railway";
    private static String username = "root";
    private static String password = "rgsd9O8LdB5YZZVqHaah";
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
            System.out.println("Error de drivar");
        }

        return connection;
        // System.out.println("conexion exitosa siiiiiii");
    }
}