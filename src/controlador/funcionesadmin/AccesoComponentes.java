package controlador.funcionesadmin;

import vista.FuncionesAdmin;

public class AccesoComponentes {

    private final FuncionesAdmin jframe;

    public AccesoComponentes(FuncionesAdmin jframe) {
        this.jframe = jframe;
    }

    public void isEditable(boolean editable) {

        this.jframe.getTxtPreguntaContenido().setEditable(editable);
        this.jframe.getTxtCategoria().setEditable(editable);
        this.jframe.getTxtDificultad().setEditable(editable);
        this.jframe.getTxtPuntos().setEditable(editable);
        this.jframe.getRbtnOpcion1().setEnabled(editable);
        this.jframe.getTxtOpcion1().setEditable(editable);
        this.jframe.getRbtnOpcion2().setEnabled(editable);
        this.jframe.getTxtOpcion2().setEditable(editable);
        this.jframe.getRbtnOpcion3().setEnabled(editable);
        this.jframe.getTxtOpcion3().setEditable(editable);
        this.jframe.getRbtnOpcion4().setEnabled(editable);
        this.jframe.getTxtOpcion4().setEditable(editable);
        this.jframe.getBtnGuardar().setVisible(editable);
        this.jframe.getBtnCancelar().setVisible(editable);
        this.jframe.getBtnEditar().setEnabled(!editable);

    }

    public void setVistaComponentes(boolean infoNivel, boolean btnsPregunta, boolean preguntayOpcion) {

        //infoNivel 
        this.jframe.getLblCategoria().setVisible(infoNivel);
        this.jframe.getTxtCategoria().setVisible(infoNivel);
        this.jframe.getLblPuntos().setVisible(infoNivel);
        this.jframe.getTxtPuntos().setVisible(infoNivel);
        this.jframe.getLblDificultad().setVisible(infoNivel);
        this.jframe.getTxtDificultad().setVisible(infoNivel);
        
        //btnsPregunta
        this.jframe.getBtnPregunta1().setVisible(btnsPregunta);
        this.jframe.getBtnPregunta2().setVisible(btnsPregunta);
        this.jframe.getBtnPregunta3().setVisible(btnsPregunta);
        this.jframe.getBtnPregunta4().setVisible(btnsPregunta);
        this.jframe.getBtnPregunta5().setVisible(btnsPregunta);
        
        //preguntaOpcion
        this.jframe.getTxtPreguntaContenido().setVisible(preguntayOpcion);
        this.jframe.getScrolltxtPreguntaContenido().setVisible(preguntayOpcion);
        this.jframe.getTxtOpcion1().setVisible(preguntayOpcion);
        this.jframe.getTxtOpcion2().setVisible(preguntayOpcion);
        this.jframe.getTxtOpcion3().setVisible(preguntayOpcion);
        this.jframe.getTxtOpcion4().setVisible(preguntayOpcion);
        this.jframe.getRbtnOpcion1().setVisible(preguntayOpcion);
        this.jframe.getRbtnOpcion2().setVisible(preguntayOpcion);
        this.jframe.getRbtnOpcion3().setVisible(preguntayOpcion);
        this.jframe.getRbtnOpcion4().setVisible(preguntayOpcion);
        this.jframe.getBtnEditar().setVisible(preguntayOpcion);
    }

}
