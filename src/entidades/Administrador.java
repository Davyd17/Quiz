package entidades;

public class Administrador extends Usuario{

    private int adminId;
    private int usuarioId;

    public Administrador(){

    }

    public Administrador(int adminId, int usuarioId){
        this.adminId = adminId;
        this.usuarioId = usuarioId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
