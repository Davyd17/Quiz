/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin;

import controlador.Info;
import modelo.entidades.Opcion;
import vista.FuncionesAdmin;

/**
 *
 * @author PC1
 */
public class ShowInfo {
    
    private final FuncionesAdmin FUNCIONESADMIN;
    private boolean resultado;
    private static Info info;

    public ShowInfo(FuncionesAdmin FUNCIONESADMIN) {
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
            FUNCIONESADMIN.getTxtOpcion1().setText(opciones[0].getContenido());
            FUNCIONESADMIN.getRbtnOpcion1().setSelected(opciones[0].isRespuesta());
            FUNCIONESADMIN.getTxtOpcion2().setText(opciones[1].getContenido());
            FUNCIONESADMIN.getRbtnOpcion2().setSelected(opciones[1].isRespuesta());
            FUNCIONESADMIN.getTxtOpcion3().setText(opciones[2].getContenido());
            FUNCIONESADMIN.getRbtnOpcion3().setSelected(opciones[2].isRespuesta());
            FUNCIONESADMIN.getTxtOpcion4().setText(opciones[3].getContenido());
            FUNCIONESADMIN.getRbtnOpcion4().setSelected(opciones[3].isRespuesta());
        }
    }

   
    
}
