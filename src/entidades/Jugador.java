package entidades;

public class Jugador extends Usuario{

    private int jugadorId;
    private int usuarioId;
    private int nivelId;
    private int puntosAcumulados;

    public Jugador() {
    }

    public Jugador(int jugadorId, int usuarioId, int nivelId, int puntosAcumulados) {
        this.jugadorId = jugadorId;
        this.usuarioId = usuarioId;
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(int jugadorId) {
        this.jugadorId = jugadorId;
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

