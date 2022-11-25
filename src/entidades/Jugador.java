package entidades;

public class Jugador extends Usuario{

    // Error al sobreescribir la variable, eliminarla y llamar al metodo super en el contructor
    private int jugadorId;
    private int nivelId;
    private int puntosAcumulados;

    public Jugador() {
    }

    public Jugador(int jugadorId, int usuarioId, int nivelId, int puntosAcumulados) {
        this.jugadorId = jugadorId;
        this.setUsuarioId(usuarioId);
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
    }

    public Jugador(int usuarioId, int jugadorId, String nombreUsuario,  int nivelId, int puntosAcumulados) {
        super.setUsuarioId(usuarioId);
        super.setNombreUsuario(nombreUsuario);
        this.jugadorId = jugadorId;
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
    }



    public int getRol() {
        return jugadorId;
    }

    public void setRol(int rol) {
        this.jugadorId = rol;
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

    public int getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(int jugadorId) {
        this.jugadorId = jugadorId;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "jugadorId = " + jugadorId +
                ", usuarioId = " + super.getUsuarioId() +
                ", nombreUsuario = " + super.getNombreUsuario() +
                ", nivelId = " + nivelId +
                ", puntosAcumulados = " + puntosAcumulados +
                '}';
    }
}



