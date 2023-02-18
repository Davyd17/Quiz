package modelo.transferobject;

import java.io.Serializable;

public class AdminDto extends UsuarioDto implements Serializable {

    private int adminId;

    public AdminDto(){

    }

    public AdminDto(int usuarioId, int adminId, String nombreUsuario) {
        super.setUsuarioId(usuarioId);
        this.adminId = adminId;
        super.setNombreUsuario(nombreUsuario);
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    @Override
    public String toString() {
        return "AdminDto{" +
                "usuarioId=" + super.getUsuarioId() +
                ", adminId=" + adminId +
                ", nombre_usuario='" + super.getNombreUsuario() + '\'' +
                '}';
    }
}
