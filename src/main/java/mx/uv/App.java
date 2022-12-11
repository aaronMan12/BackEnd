package mx.uv;

import static spark.Spark.*;
import java.util.UUID;
import com.google.gson.*;

public class App {
  /**
   * @param args
   * 
   */
  public static Gson gson = new Gson();

  public static void main(String[] args) {
    port(DaPuerto());
    staticFiles.externalLocation("/");
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
    before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
    get("/productos", (req, res) -> {
      res.type("application/json");
      return gson.toJson(DAO.DaProductos());
    });

    post("/creaProductos", (req, res) -> {
      String id = UUID.randomUUID().toString();
      String datosUsu = req.body();
      final Producto p1 = gson.fromJson(datosUsu, Producto.class);
      p1.setID(id);
      DAO.NewProducto(p1);
      return DAO.NewProducto(p1);
    });

    get("/borrarProducto", (req, res) -> {
      System.out.println(req.queryParams("id"));
      return DAO.eliminaDAO(req.queryParams("id"));
    });

    put("/actualizarProducto",(req,res)->{
      String datosUsu =req.body();
      final Producto p1 = gson.fromJson(datosUsu, Producto.class);
      DAO.actualizarDAO(p1);
      return "actualizado";
    });


  }


   

  private static int DaPuerto() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 4567;
  }
}