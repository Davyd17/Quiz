package entidades;

public class Administrador {

    private int id;
    private int usuarioId;

    public Administrador(){

    }

    public Administrador(int id, int usuarioId){
        this.id = id;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
