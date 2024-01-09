/*
 * ComandaDB
 */
package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Comanda;
import modelo.Empleado;
import modelo.Plato;

/**
 *
 * @author Di Qi
 */
public class ComandaDB {

    private static Connection conexion;
    private static ResultSet resultset = null;
    private static Empleado empleado;

    /**
     * Obtener la comanda actual
     * @return comanda
     * @throws MiExcepcion 
     */
    public static Comanda getComandaActual() throws MiExcepcion {
        try {
            return new Comanda(
                    resultset.getInt(1),
                    resultset.getInt(2),
                    resultset.getString(3),
                    resultset.getDate(4).toLocalDate(),
                    resultset.getFloat(5),
                    resultset.getFloat(6),
                    empleado
            );
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }

    /**
     * Iniciar vista comandas individual
     */
    public static void iniciar() throws MiExcepcion {
        String sql = "select * from comanda where id_empleado = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(
                    sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
            stm.setInt(1, empleado.getId());

            resultset = stm.executeQuery();
            resultset.first();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Siguiente comanda
     * @throws MiExcepcion 
     */
    public static void siguiente() throws MiExcepcion {
        try {
            resultset.next();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Anterior comanda
     * @throws MiExcepcion 
     */
    public static void anterior() throws MiExcepcion {
        try {
            resultset.previous();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Primera comanda
     * @throws MiExcepcion 
     */
    public static void primera() throws MiExcepcion {
        try {
            resultset.first();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Última comanda
     * @throws MiExcepcion 
     */
    public static void ultima() throws MiExcepcion {
        try {
            resultset.last();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Finalizar vista comandas individual
     * @throws MiExcepcion 
     */
    public static void finalizar() throws MiExcepcion {
        try {
            if (resultset != null) {
                resultset.close();
            }
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(106);
        }
    }
    
    /**
     * Obtener si es la primera comanda
     * @return true si sí, false si no
     * @throws MiExcepcion 
     */
    public static boolean esPrimera() throws MiExcepcion {
        try {
            return resultset.isFirst();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }
    
    /**
     * Obtener si es la última comanda
     * @return true si sí, false si no
     * @throws MiExcepcion 
     */
    public static boolean esUltima() throws MiExcepcion {
        try {
            return resultset.isLast();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }
    }

    /**
     * Lista de todas las comandas de un empleado
     *
     * @return lista de comandas
     * @throws MiExcepcion
     */
    public static List<Comanda> getComandas() throws MiExcepcion {
        List<Comanda> res = new ArrayList<>();
        String sql = "select * from comanda where id_empleado = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, empleado.getId());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                res.add(new Comanda(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getFloat(5),
                        rs.getFloat(6),
                        empleado
                ));
            }

            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }

        return res;
    }

    /**
     * Obtener el id de una nueva comanda
     *
     * @return id
     * @throws MiExcepcion
     */
    public static int getNuevaComandaId() throws MiExcepcion {
        int res = -1;
        String sql = "select max(id) + 1 from comanda";

        try {
            Statement stm = conexion.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res = rs.getInt(1);
            }

            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }

        return res;
    }
    
    /**
     * Obtener el número de comandas tota
     * @return
     * @throws MiExcepcion 
     */
    public static int getNumeroComandas() throws MiExcepcion {
        int res = -1;
        String sql = "select count(*) from comanda where id_empleado = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, empleado.getId());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                res = rs.getInt(1);
            }

            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }

        return res;
    }
    
    /**
     * Crea una comanda en la base de datos
     * @param c comanda
     * @param lc lineas de comanda
     */
    public static void crearComanda(Comanda c, Map<Plato, Integer> lc) throws MiExcepcion {
        try {
            if (getNumeroComandas() > 0) {
                resultset.moveToInsertRow();
                resultset.updateInt(1, c.getId());
                resultset.updateInt(2, c.getMesa());
                resultset.updateString(3, c.getNombre());
                resultset.updateDate(4, Date.valueOf(c.getFecha()));
                resultset.updateFloat(5, c.getTotal());
                resultset.updateFloat(6, c.getTotalMaximo());
                resultset.updateInt(7, c.getEmpleado().getId());
                resultset.insertRow();
                resultset.moveToCurrentRow();
            } else {
                String sql = "insert into comanda values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = conexion.prepareStatement(sql);
                stm.setInt(1, c.getId());
                stm.setInt(2, c.getMesa());
                stm.setString(3, c.getNombre());
                stm.setDate(4, Date.valueOf(c.getFecha()));
                stm.setFloat(5, c.getTotal());
                stm.setFloat(6, c.getTotalMaximo());
                stm.setInt(7, c.getEmpleado().getId());
                stm.executeUpdate();
                stm.close();
                
                iniciar();
            }
            ComandaPlatoDB.crearLineasComanda(c.getId(), lc);
            
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(107);
        }
    }
    
    /**
     * Modificar una comanda en la base de datos
     * @param c comanda
     * @param lc lineas de comanda
     */
    public static void modificarComanda(Comanda c, Map<Plato, Integer> lc) throws MiExcepcion {
        try {
            resultset.updateInt(1, c.getId());
            resultset.updateInt(2, c.getMesa());
            resultset.updateString(3, c.getNombre());
            resultset.updateDate(4, Date.valueOf(c.getFecha()));
            resultset.updateFloat(5, c.getTotal());
            resultset.updateFloat(6, c.getTotalMaximo());
            resultset.updateInt(7, c.getEmpleado().getId());
            resultset.updateRow();
            
            ComandaPlatoDB.modificarLineasComanda(c.getId(), lc);
            
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(108);
        }
    }
    
    /**
     * Eliminar la comanda actual
     * @throws MiExcepcion 
     */
    public static void eliminarComanda() throws MiExcepcion {
        try {
            resultset.deleteRow();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(109);
        }
    }
    
    public static void setConexion(Connection c) {
        conexion = c;
    }
    public static void setEmpleado(Empleado e) {
        empleado = e;
    }
    

}
