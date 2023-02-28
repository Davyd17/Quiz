
package controlador.juego;

import controlador.Info;
import modelo.negocio.JugadorControl;
import vista.Juego;

public class JugadorInfoControl {
    
    private final JugadorControl JUGADOR_CONTROL;

    public JugadorInfoControl(Juego JUEGO) {
        this.JUGADOR_CONTROL = new JugadorControl();
    }
    
    public boolean actualizarJugador(int nivel, int puntosAcumulados){
        
        if(JUGADOR_CONTROL.editar(Info.getInfoJugador().getJugadorId(), nivel, puntosAcumulados)){
            
            Info.setInfoJugador(JUGADOR_CONTROL.obtenerPorUsuario(Info.getInfoJugador().getUsuarioId()));
            return true;          
            
        } else return false;
             
    }
  
    
    
    
}
