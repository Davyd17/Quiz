/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin;

import controlador.Info;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.entidades.Opcion;
import modelo.negocio.NivelControl;
import modelo.negocio.OpcionControl;
import modelo.negocio.PreguntaControl;
import vista.FuncionesAdmin;

public class AdminInfoControl {

    private final FuncionesAdmin FUNCIONESADMIN;
    private boolean resultado;
    private static Info info;
    private final JTextField[] OPCIONES_JTEXTFIELD;
    private final JRadioButton[] OPCIONES_JRADIOBUTTON;

    public AdminInfoControl(FuncionesAdmin FUNCIONESADMIN) {
        this.FUNCIONESADMIN = FUNCIONESADMIN;
        this.OPCIONES_JTEXTFIELD = new ControlOpciones(FUNCIONESADMIN).getOpcionesTextField();
        this.OPCIONES_JRADIOBUTTON = new ControlOpciones(FUNCIONESADMIN).getOpcionesRadioButton();
        info = new Info();
    }

    public boolean editInfo() {

        boolean nivelEditado = new NivelControl().editar(FuncionesAdmin.getNivelSeleccionado(),
                FUNCIONESADMIN.getTxtCategoria().getText(),
                Integer.parseInt(FUNCIONESADMIN.getTxtPuntos().getText()),
                FUNCIONESADMIN.getTxtDificultad().getText());

        boolean preguntaEditada = new PreguntaControl().editar(Info.getListaPreguntas().get(FuncionesAdmin.getPreguntaIndice()).getPreguntaId(),
                Info.getNivelDto().getNivelId(),
                FUNCIONESADMIN.getTxtPreguntaContenido().getText());

        boolean opcionesEditadas = false;
        
        int validacion = 0;
        for (int i = 0; i <= Info.getListaOpciones().get(FuncionesAdmin.getPreguntaIndice()).length - 1; i++) {

            Opcion[] opciones = Info.getListaOpciones().get(FuncionesAdmin.getPreguntaIndice());

            if (new OpcionControl().editar(opciones[i].getId(), opciones[i].getPreguntaId(),
                    OPCIONES_JTEXTFIELD[i].getText(), OPCIONES_JRADIOBUTTON[i].isSelected())) {
                validacion++;
            }

            if (validacion == Info.getListaOpciones().get(FuncionesAdmin.getPreguntaIndice()).length - 1) {
                opcionesEditadas = true;
            }

        }

        if (nivelEditado && preguntaEditada && opcionesEditadas) {

            resultado = true;

        } else {
            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Hubo un error en la edicion", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    public boolean insertNewNivel() {

        NivelControl nivelControl = new NivelControl();

        boolean nivelCreado = nivelControl.insertar(FuncionesAdmin.getNivelSeleccionado(),
                FUNCIONESADMIN.getTxtCategoria().getText(),
                Integer.parseInt(FUNCIONESADMIN.getTxtPuntos().getText()),
                FUNCIONESADMIN.getTxtDificultad().getText());

        Info.setNivelDto(nivelControl.obtener(FuncionesAdmin.getNivelSeleccionado()));

        return nivelCreado;
    }

    public boolean insertNewPregunta() {

        PreguntaControl preguntaControl = new PreguntaControl();

        boolean preguntaCreada = preguntaControl.insertar(Info.getNivelDto().getNivelId(), FUNCIONESADMIN.getTxtPreguntaContenido().getText());

        Info.setNivelDto(new NivelControl().obtener(FuncionesAdmin.getNivelSeleccionado()));

        int preguntaId = Info.getNivelDto().getPreguntas().get(FuncionesAdmin.getPreguntaIndice()).getPreguntaId();

        boolean opcionesEditadas = false;

        int validacion = 0;
        for (int i = 0; i <= 3; i++) {

            if (new OpcionControl().insertar(preguntaId,
                    OPCIONES_JTEXTFIELD[i].getText(),
                    OPCIONES_JRADIOBUTTON[i].isSelected())) {
                validacion++;
            }
        }

        if (validacion == 4) {
            opcionesEditadas = true;
        }

        if (preguntaCreada && opcionesEditadas) {
            resultado = true;

        } else {
            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Hubo un error en la creacion", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

}
