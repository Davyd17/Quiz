package entidades;

public class Administrador extends Usuario{

    private int adminId;

    public Administrador(){

    }

    public Administrador(int adminId, int usuarioId){
        this.adminId = adminId;
        super.setUsuarioId(usuarioId);
    }

    public Administrador(int usuarioId, int adminId, String nombreUsuario) {
        super.setUsuarioId(usuarioId);
        this.adminId = adminId;
        this.setNombreUsuario(nombreUsuario);
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    @Override
    public String toString() {
        return "Administrador{" +
                "adminId=" + adminId +
                ", nombreUsuario" + super.getNombreUsuario() +
                ", usuarioId=" + super.getUsuarioId() +
                '}';
    }
}
