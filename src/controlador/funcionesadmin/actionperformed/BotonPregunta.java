/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin.actionperformed;

import controlador.Info;
import java.awt.event.ActionEvent;
import vista.FuncionesAdmin;

/**
 *
 * @author PC1
 */
public final class BotonPregunta extends ActionPerformedAbstract{

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
