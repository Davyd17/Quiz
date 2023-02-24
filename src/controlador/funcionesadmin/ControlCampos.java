
package controlador.funcionesadmin;

import controlador.Info;
import javax.swing.JOptionPane;
import vista.FuncionesAdmin;


public class ControlCampos {
    
    private final FuncionesAdmin FUNCIONESADMIN;
    private boolean resultado;
    private static Info info;

    public ControlCampos(FuncionesAdmin FUNCIONESADMIN) {
        this.FUNCIONESADMIN = FUNCIONESADMIN;
        info = new Info();
    }
    
     public boolean validarCamposVacios() {

        if (Info.getNivelDto() == null) {

            if (FUNCIONESADMIN.getTxtCategoria().getText().isEmpty()
                    || FUNCIONESADMIN.getTxtDificultad().getText().isEmpty()
                    || FUNCIONESADMIN.getTxtPuntos().getText().isEmpty()) {

                JOptionPane.showMessageDialog(FUNCIONESADMIN, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                resultado = true;

            }

        } else if (FUNCIONESADMIN.getTxtCategoria().getText().isEmpty()
                || FUNCIONESADMIN.getTxtDificultad().getText().isEmpty()
                || FUNCIONESADMIN.getTxtPuntos().getText().isEmpty()
                || FUNCIONESADMIN.getTxtPreguntaContenido().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion1().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion2().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion3().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion4().getText().isEmpty()) {

            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Todos los campos son obligatorios", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

        } else {

            resultado = true;
        }

        return resultado;

    }

    public void vaciarCampos(boolean seccionNivel, boolean seccionPregunta) {

        if (seccionNivel) {

            FUNCIONESADMIN.getTxtCategoria().setText("");
            FUNCIONESADMIN.getTxtDificultad().setText("");
            FUNCIONESADMIN.getTxtPuntos().setText("");

        }
        if (seccionPregunta) {

            FUNCIONESADMIN.getTxtPreguntaContenido().setText("");

            FUNCIONESADMIN.getTxtOpcion1().setText("");
            FUNCIONESADMIN.getTxtOpcion2().setText("");
            FUNCIONESADMIN.getTxtOpcion3().setText("");
            FUNCIONESADMIN.getTxtOpcion4().setText("");

            FUNCIONESADMIN.getRbtnOpcion1().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion2().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion3().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion4().setSelected(seccionPregunta);

        }

    }
}
