package Model;

//esta clase guarda el nombre de usuario con el metodo getNombreUsuario para ser utilizada mas tarde
public class Usuario {
    private static String nombreUsuario;

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        Usuario.nombreUsuario = nombreUsuario;
    }
}
