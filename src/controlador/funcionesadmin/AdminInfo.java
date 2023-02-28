/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin;

import controlador.Info;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.entidades.Opcion;
import vista.FuncionesAdmin;

/**
 *
 * @author PC1
 */
public class AdminInfo {

    private final FuncionesAdmin FUNCIONESADMIN;
    private boolean resultado;
    private static Info info;

    public AdminInfo(FuncionesAdmin FUNCIONESADMIN) {
        this.FUNCIONESADMIN = FUNCIONESADMIN;
        info = new Info();
    }

    public boolean showNivel() {
        if (info.getInfoNivel(FuncionesAdmin.getNivelSeleccionado())) {
            FUNCIONESADMIN.getTxtCategoria().setText(Info.getNivelDto().getCategoria());
            FUNCIONESADMIN.getTxtPuntos().setText(Integer.toString(Info.getNivelDto().getPuntos()));
            FUNCIONESADMIN.getTxtDificultad().setText(Info.getNivelDto().getDificultad());
            showPregunta();
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    private void showPregunta() {

        if (Info.getListaPreguntas() != null && Info.getListaPreguntas().size() > FuncionesAdmin.getPreguntaIndice()) {
            FUNCIONESADMIN.getTxtPreguntaContenido().setText(Info.getListaPreguntas().get(FuncionesAdmin.getPreguntaIndice()).getContenido());

            Opcion[] opciones = Info.getListaOpciones().get(FuncionesAdmin.getPreguntaIndice());

            JTextField[] txtOpciones = new ControlOpciones(FUNCIONESADMIN).getOpcionesTextField();
            JRadioButton[] botonOpciones = new ControlOpciones(FUNCIONESADMIN).getOpcionesRadioButton();

            for (int i = 0; i <= opciones.length - 1; i++) {

                txtOpciones[i].setText(opciones[i].getContenido());
                botonOpciones[i].setSelected(opciones[i].isRespuesta());

            }
        }
    }

}
