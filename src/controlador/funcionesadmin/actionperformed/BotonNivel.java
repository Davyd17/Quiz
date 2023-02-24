package controlador.funcionesadmin.actionperformed;

import java.awt.event.ActionEvent;
import vista.FuncionesAdmin;

public final class BotonNivel extends ActionPerformedAbstract {

    public BotonNivel(ActionEvent e, FuncionesAdmin FUNCIONES_ADMIN, int nivelSeleccionado) {
        super(FUNCIONES_ADMIN);
        FuncionesAdmin.setNivelSeleccionado(nivelSeleccionado);
        this.actionPerformed(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //FuncionesAdmin.setPreguntaIndice(0);

        if (super.getSHOW_INFO().showNivel()) {
            super.getACCESO_COMPONENTES().setVistaComponentes(true, true, false);
            super.getACCESO_COMPONENTES().isEditable(false);

        } else {

            super.getACCESO_COMPONENTES().setVistaComponentes(true, false, false);
            super.getCONTROL_CAMPOS().vaciarCampos(true, true);
            super.getACCESO_COMPONENTES().isEditable(true);

        }

    }

}
