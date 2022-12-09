package mx.uv;

public class Producto {
    String id;
    String nombre;
    String precio;
    String link;

    public Producto(String iD2, String nombre1, String pre, String linck1) {
        this.id = iD2;
        this.nombre = nombre1;
        this.precio = pre;
        this.link = linck1;
    }

    public String getID() {
        return id;
    }

    public void setID(String iD) {
        id = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getLinck() {
        return link;
    }

    public void setLinck(String linck) {
        this.link = linck;
    }

}
