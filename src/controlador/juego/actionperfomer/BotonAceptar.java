
package controlador.juego.actionperfomer;

import java.awt.event.ActionEvent;
import vista.Juego;

public class BotonAceptar extends ActionPerformerAbstract{

    public BotonAceptar(Juego JUEGO, ActionEvent evt) {
        super(JUEGO, evt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(super.getJUEGO_CONTROL().subirNivel()) super.getJUEGO_CONTROL().GanarJuego();
         else super.getJUEGO_CONTROL().GameOver();
        
        
    }

  
}
