package transferobject;

import java.io.Serializable;

public class AdminDTO implements Serializable {

    private int usuarioId;
    private int adminId;
    private String nombre_usuario;


    public AdminDTO() {
    }

    public AdminDTO(int usuarioId, int adminId, String nombre_usuario) {
        this.usuarioId = usuarioId;
        this.adminId = adminId;
        this.nombre_usuario = nombre_usuario;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
