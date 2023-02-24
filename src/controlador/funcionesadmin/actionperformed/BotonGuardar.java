/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin.actionperformed;

import controlador.Info;
import java.awt.event.ActionEvent;
import vista.FuncionesAdmin;

public final class BotonGuardar extends ActionPerformedAbstract{

    public BotonGuardar(ActionEvent evt, FuncionesAdmin FUNCIONES_ADMIN) {
        super(FUNCIONES_ADMIN);
        this.actionPerformed(evt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (super.getCONTROL_CAMPOS().validarCamposVacios()) {

            if (Info.getNivelDto() != null && Info.getListaPreguntas() != null && FuncionesAdmin.getPreguntaIndice() <= Info.getListaPreguntas().size() - 1) {

                if (super.getINFO_CONTROL().editInfo()) {
                    super.getACCESO_COMPONENTES().isEditable(false);
                    super.getSHOW_INFO().showNivel();
                }
            } else if (Info.getNivelDto() == null) {

                if (super.getINFO_CONTROL().insertNewNivel()) {
                    super.getACCESO_COMPONENTES().isEditable(false);
                    super.getSHOW_INFO().showNivel();
                    super.getACCESO_COMPONENTES().setVistaComponentes(true, true, false);
                }

            } else {

                if (super.getINFO_CONTROL().insertNewPregunta()) {
                    super.getACCESO_COMPONENTES().isEditable(false);
                    super.getSHOW_INFO().showNivel();
                }
            }
        }
    }
    
}
