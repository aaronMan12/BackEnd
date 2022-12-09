package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

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

    get("/", (req, res) -> {
      Map<String, Object> variables = new HashMap<>();
      variables.put("name", "Joaquin");
      IContext context = new Context(req.raw().getLocale(), variables);
      String out = ThymeleafUtil.getTemplateEngine().process("../index.html", context);
      return out;
    });

    get("/productos", (req, res) -> {
      res.type("application/json");
      return gson.toJson(DAO.DaProductos());
    });

    post("/creaProductos", (req, res) -> {
      String id_ = req.queryParams("id");
      JsonObject objetoJson = new JsonObject();
      String datosUsu = req.body();
      final Producto p1 = gson.fromJson(datosUsu, Producto.class);
      DAO.NewProducto(p1);
      return p1.getID();
    });

    // get("/productos", (req, res) -> gson.toJson(DAO.DaProductos()) );
    // Producto producto1=new Producto(10,"Cloro",200,"thhps");
    // DAO.NewProducto(producto1);
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