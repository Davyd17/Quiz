package modelo.entidades;

//Entidad que mapea la tabla jugador de la base de datos
public class Jugador{

    // Atributos
    private int id;
    private int usuarioId; //Foreign Key
    private int nivelId;
    private int puntosAcumulados;

    // Constructor por defecto
    public Jugador() {
    }

    // Constructor
    public Jugador(int id, int usuarioId, int nivelId, int puntosAcumulados) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
    }

    // Getters & Setters
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

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }
}



