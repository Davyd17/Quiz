
package modelo.negocio;

import modelo.datos.mysql.MySQLJugadorDAO;
import modelo.entidades.Jugador;
import modelo.mapper.JugadorMapper;
import modelo.transferobject.JugadorDto;


public class JugadorControl {

    private final MySQLJugadorDAO DATOS;
    private Jugador entidad;
    private boolean respuesta;

    public JugadorControl() {
        this.DATOS = new MySQLJugadorDAO();
    }

    public boolean editar(int id, int nivel, int puntosAcumulados) {

        entidad = new Jugador();
        entidad.setId(id);
        entidad.setNivel(nivel);
        entidad.setPuntosAcumulados(puntosAcumulados);

        respuesta = DATOS.actualizar(entidad);

        return respuesta;
    }

    public JugadorDto obtenerPorUsuario(int usuarioId) {
        
        this.entidad = DATOS.obtenerPorUsuario(usuarioId);

        JugadorDto jugadorDto = new JugadorMapper().CreateDTO(entidad, new UsuarioControl().obtener(usuarioId)); 
                

        return jugadorDto;

    }

}
