package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

import spark.Request;


public class App {
  /**
 * @param args
 * 
 */
  public static Gson gson = new Gson();
public static void main(String[] args) {
    port(DaPuerto());
    Conexion.getConnection();
  
    options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            System.out.println(accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            System.out.println(accessControlRequestMethod); 
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((req, res)-> res.header("Access-Control-Allow-Origin", "*"));


        get("/productos", (req, res) -> {
          res.type("application/json");
          return gson.toJson(DAO.DaProductos());
        });
        
        post("/creaProductos", (req, res) -> {
        //  String msj = extracted(req);
         // String ID =req.queryParams("id");
          //String nombre = req.queryParams("nombre");
          //String precio = req.queryParams("precio");
          //String linck =req.queryParams("link");
        // Integer ID2 = Integer.parseInt(ID);
          //Float  precio2=Float.parseFloat(precio ); 
          String msj =extracted(req); 
          Producto p = new Producto(13, "calabaza en dulce", 2334, "linck de prueba");
          // devolver una respuesta JSON
          DAO.NewProducto(p);
          //JsonObject objetoJson = new JsonObject();
          //objetoJson.addProperty("status", DAO.NewProducto(p));
          //objetoJson.addProperty("id", p.getID());
          return msj;
      });
  
        
        //get("/productos", (req, res) -> gson.toJson(DAO.DaProductos()) );
        //Producto producto1=new Producto(10,"Cloro",200,"thhps");
        //DAO.NewProducto(producto1);
  }

private static String extracted(Request req) {
  String datos = req.body();
  return datos;
}

  private static int DaPuerto() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 4567;
  }
}