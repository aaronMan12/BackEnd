package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.UUID;
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
        
        /*post("/creaProductos", (req, res) -> {
          String datos = req.body();
          String id = UUID.randomUUID().toString();
          Producto u = gson.fromJson(datos, Producto.class);
          u.setID(id);

          // devolver una respuesta JSON
          JsonObject objetoJson = new JsonObject();
          objetoJson.addProperty("status", DAO.NewProducto(u));
          objetoJson.addProperty("id", id);
          return objetoJson;
      });*/
  
        
        //get("/productos", (req, res) -> gson.toJson(DAO.DaProductos()) );
        //Producto producto1=new Producto(10,"Cloro",200,"thhps");
        //DAO.NewProducto(producto1);
  }

  private static int DaPuerto() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 4567;
  }
}