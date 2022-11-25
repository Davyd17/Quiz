package entidades;

public class Usuario {

    private int usuarioId;
    private String nombreUsuario;
    private String contrasena;

    /*
    El rol se define entre 1 y 2:
     1: Jugador
     2: Administrador
     */
    private int rol;

    public Usuario(){
    }

    public Usuario(int usuarioId, String nombreUsuario, String contrasena, int rol){
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario(int usuarioId, String nombreUsuario, int rol) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int adminId) {
        this.usuarioId = adminId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
