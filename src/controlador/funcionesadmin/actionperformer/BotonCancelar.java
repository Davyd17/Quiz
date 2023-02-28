
package controlador.funcionesadmin.actionperformer;

import controlador.Info;
import java.awt.event.ActionEvent;
import vista.FuncionesAdmin;

public final class BotonCancelar extends ActionPerformerAbstract{

    public BotonCancelar(ActionEvent evt, FuncionesAdmin FUNCIONES_ADMIN) {
        super(FUNCIONES_ADMIN);
        this.actionPerformed(evt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (Info.getNivelDto() != null) {

                super.getCONTROL_CAMPOS().vaciarCampos(false, true);
                super.getACCESO_COMPONENTES().setVistaComponentes(true, true, false);
            
        } else {
            super.getCONTROL_CAMPOS().vaciarCampos(true, true);
            super.getACCESO_COMPONENTES().setVistaComponentes(false, false, false);
        }

        super.getACCESO_COMPONENTES().isEditable(false);
    }
    
}
