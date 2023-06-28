package Model;

/**
 * Clase la cual representa el usuario y permite guardar su nombre para posteriormente ser usado en mensajes felicitacion.
 */
public class Usuario {
    private static String nombreUsuario;

    /**
     * obtiene el nombre del usuario.
     *
     * @return El nombre de usuario.
     */

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     * Establece un metodo relacionado con el controlador iniciar.
     * @param nombreUsuario El nombre de usuario a establecer.
     */


    public static void setNombreUsuario(String nombreUsuario) {
        Usuario.nombreUsuario = nombreUsuario;
    }
}
