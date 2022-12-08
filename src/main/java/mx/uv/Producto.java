package mx.uv;

public class Producto {
    int ID;
    String nombre;
    float precio;
    String linck;

    /**
     * 
     */
    public Producto(int iD2, String nombre1, int i, String linck1) {
        this.ID = iD2;
        this.nombre = nombre1;
        this.precio = i;
        this.linck = linck1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getLinck() {
        return linck;
    }

    public void setLinck(String linck) {
        this.linck = linck;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id2) {
        ID = id2;
    }

}
