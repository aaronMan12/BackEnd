package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String sql = "SELECT * FROM Productos";
            stm = (Statement) con.createStatement();
            rs = ((java.sql.Statement) stm).executeQuery(sql);
            while (rs.next()) {
                Producto u = new Producto(rs.getString("ID"),
                rs.getString("nombre"), rs.getString("precio"),
                rs.getString("link"));
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


        public static String NewProducto(Producto p){
        String msj="Alta exitota";
        PreparedStatement stm=null;
        Connection con=null;
        con=con1.getConnection();
        
        try {
            String sql = "INSERT INTO Productos (ID, nombre, precio, link) values (?,?,?,?)";
            stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, p.getID());
            stm.setString(2, p.getNombre()); 
            stm.setString(3, p.getPrecio());
            stm.setString(4, p.getLinck());
            if (stm.executeUpdate() > 0)
                msj = "usuario agregado";
            else
                msj = "usuario no agregado";

        } catch (Exception e) {
            System.out.println(e);
        } finally {
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

        return msj;
        }

        


}