package mx.uv;



public class Producto {
int ID;
String nombre;
float precio;
String linck;

/**
 * 
 */
public Producto(int id,String nombre1,float precio1,String linck1) {
this.ID=id;
this.nombre=nombre1;
this.precio=precio1;
this.linck=linck1;    
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
public void setID(int iD) {
    ID = iD;
}


}
