package transferobject;

public class UsuarioDto {

    private int usuarioId;
    private String nombreUsuario;
    private int rol;

    public UsuarioDto(){

    };

    public UsuarioDto(int usuarioId, String nombreUsuario, int rol) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    };

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
