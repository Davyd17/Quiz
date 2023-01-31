package entidades;

// Entidad que mapea la tabla administrador de la base de datos
public class Administrador {

    // Atributos
    private int id;
    private int usuarioId; //Foreign Key

    //Constructor por defecto
    public Administrador() {

    }

    //Constructor
    public Administrador(int id, int usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
    }

    //Getters & Setters
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
