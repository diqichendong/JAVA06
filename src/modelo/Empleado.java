/*
 * Clase Empleado
 */
package modelo;

import com.aeat.valida.Validador;
import controlador.MiExcepcion;

/**
 *
 * @author Di Qi
 */
public class Empleado {
    
    private int id;
    private String usuario, password, nombre, nif, foto;

    public Empleado(int id, String usuario, String password, String nombre, String nif, String foto) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.nif = nif;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", nif=" + nif + ", foto=" + foto + '}';
    }
    
}
