package mx.uv;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    port(DaPuerto());
    get("/hola", (req, res) -> ("Hello Heroku"));
     DAO.DaProductos();
  }

  private static int DaPuerto() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 4567;
  }
}