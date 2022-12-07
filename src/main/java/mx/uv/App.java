package mx.uv;

import static spark.Spark.*;

public class App {
  /**
 * @param args
 */
public static void main(String[] args) {
    port(DaPuerto());
    get("/hola", (req, res) -> ("Hello Heroku"));
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
  
  
  
  }

  private static int DaPuerto() {
    String herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
      return Integer.parseInt(herokuPort);
    }
    return 4567;
  }

}
