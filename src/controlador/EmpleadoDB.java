/*
 * EmpleadoDB
 */
package controlador;

import java.sql.*;
import modelo.Empleado;

/**
 *
 * @author Di Qi
 */
public class EmpleadoDB {

    private Connection conexion;

    public EmpleadoDB(Connection conexion) {
        this.conexion = conexion;
    }

    public Empleado getEmpleadoInicioSesion(String usuario, String password) throws MiExcepcion {
        Empleado emp = null;
        String sql = "select * from empleado where usuario = ? and password = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, usuario);
            stm.setString(2, password);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                emp = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                break;
            }
            
            rs.close();
            stm.close();
        } catch (SQLException e) {
            Utils.procedimientoLog(e);
            throw new MiExcepcion(104);
        }

        return emp;
    }
    
    public void modificarEmpleado(Empleado e) throws MiExcepcion {
        String sql = "update empleado "
                + "set usuario = ?, nombre = ?, nif = ?, foto = ? "
                + "where id = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, e.getUsuario());
            stm.setString(2, e.getNombre());
            stm.setString(3, e.getNif());
            stm.setString(4, e.getFoto());
            stm.setInt(5, e.getId());
            
            stm.executeUpdate();
            
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(105);
        }
    }

}
