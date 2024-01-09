/*
 * Clase Plato
 */
package modelo;

import controlador.Utils;
import java.text.DecimalFormat;

/**
 *
 * @author Di Qi
 */
public class Plato {
    
    private int id;
    private String nombre;
    private float precio;

    public Plato(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getPrecioStr() {
        return Utils.precioStr(precio);
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
