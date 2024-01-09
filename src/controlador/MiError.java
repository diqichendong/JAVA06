/*
 * MiError
 */
package controlador;

/**
 *
 * @author bosque
 */
public class MiError {

    private static String mensaje;

    public static String getMensaje(int cod) {
        mensaje = "Error " + cod + ": ";
        switch (cod) {
            case 101:
                mensaje = mensaje + "al cargar los drivers de la base de datos";
                break;
            case 102:
                mensaje = mensaje + "al abrir la base de datos";
                break;
            case 103:
                mensaje = mensaje + "al cerrar la base de datos";
                break;
            case 104:
                mensaje = mensaje + "al consultar la base de datos";
                break;
            case 105:
                mensaje = mensaje + "al modificar el empleado";
                break;
            case 106:
                mensaje = mensaje + "al finalizar la consulta a la base de datos";
                break;
            case 107:
                mensaje = mensaje + "al insertar en la base de datos";
                break;
            case 108:
                mensaje = mensaje + "al modificar en la base de datos";
                break;
            case 109:
                mensaje = mensaje + "al eliminar en la base de datos";
                break;
            default:
                mensaje = mensaje + "DESCONOCIDO";
        }
        return mensaje;
    }

}
