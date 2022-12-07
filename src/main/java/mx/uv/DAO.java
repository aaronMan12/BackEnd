package mx.uv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import com.mysql.cj.xdevapi.Statement;

public class DAO {
    private static Conexion con1 = new Conexion();

    /**
     * @return
     */
    public static List<Producto> DaProductos() {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<Producto> resultado = new ArrayList();

        con = con1.getConnection();

        try {
            String sql = "SELECT descripcion, precio, link FROM Productos";
            stm = (Statement) con.createStatement();
            rs = ((java.sql.Statement) stm).executeQuery(sql);
            while (rs.next()) {
                Producto u = new Producto(rs.getString("descripcion"), rs.getInt("precio"), rs.getString("link"));
                resultado.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            rs = null;
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return resultado;

    }
}
////////////////////////////

/*
 * public static List<Producto> dameUsuarios() {
 * Statement stm = null;
 * ResultSet rs = null;
 * Connection conn = null;
 * List<Usuario> resultado = new ArrayList<>();
 * 
 * conn = c.getConnection();
 * 
 * try {
 * String sql = "SELECT * from usuarios";
 * stm = (Statement) conn.createStatement();
 * rs = stm.executeQuery(sql);
 * while (rs.next()) {
 * Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"),
 * rs.getString("password"));
 * resultado.add(u);
 * }
 * } catch (Exception e) {
 * System.out.println(e);
 * } finally {
 * if (rs != null)
 * try {
 * rs.close();
 * } catch (SQLException e) {
 * System.out.println(e);
 * }
 * rs = null;
 * if (stm != null) {
 * try {
 * stm.close();
 * } catch (Exception e) {
 * System.out.println(e);
 * }
 * stm = null;
 * }
 * try {
 * conn.close();
 * } catch (Exception e) {
 * System.out.println(e);
 * }
 * }
 * 
 * return resultado;
 * }
 */

/////////////
