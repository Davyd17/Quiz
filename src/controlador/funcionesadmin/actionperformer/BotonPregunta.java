
package controlador.funcionesadmin.actionperformer;

import controlador.Info;
import java.awt.event.ActionEvent;
import vista.FuncionesAdmin;

/**
 *
 * @author PC1
 */
public final class BotonPregunta extends ActionPerformerAbstract{

    public BotonPregunta(ActionEvent evt, FuncionesAdmin FUNCIONES_ADMIN, int PreguntaIndice) {
        super(FUNCIONES_ADMIN);
        FuncionesAdmin.setPreguntaIndice(PreguntaIndice);
        this.actionPerformed(evt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.getACCESO_COMPONENTES().setVistaComponentes(true, true, true);

        if (Info.getListaPreguntas() != null && FuncionesAdmin.getPreguntaIndice() <= Info.getListaPreguntas().size() - 1) {

            super.getACCESO_COMPONENTES().isEditable(false);
            super.getSHOW_INFO().showNivel();

        } else {

            super.getCONTROL_CAMPOS().vaciarCampos(false, true);
            super.getACCESO_COMPONENTES().isEditable(true);

        }
        
    }

}
