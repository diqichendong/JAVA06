/*
 * Clase Comanda
 */
package modelo;

import controlador.Utils;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Di Qi
 */
public class Comanda {

    private int id;
    private int mesa;
    private String nombre;
    private LocalDate fecha;
    private float total;
    private float totalMaximo;
    private Empleado empleado;

    public Comanda(int id, int mesa, String nombre, LocalDate fecha, float total, float totalMaximo, Empleado empleado) {
        this.id = id;
        this.mesa = mesa;
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
        this.totalMaximo = totalMaximo;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getFechaStr() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(pattern);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }
    
    public String getTotalStr() {
        return Utils.precioStr(total);
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotalMaximo() {
        return totalMaximo;
    }
    
    public String getTotalMaximoStr() {
        return Utils.precioStr(totalMaximo);
    }

    public void setTotalMaximo(float totalMaximo) {
        this.totalMaximo = totalMaximo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Pedido " + id + " - " + total + " € [" + fecha.toString() + "]";
    }

}
