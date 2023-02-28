
package controlador.funcionesadmin;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import vista.FuncionesAdmin;

public class ControlOpciones{
    
    private final FuncionesAdmin FUNCIONESADMIN;

    protected ControlOpciones(FuncionesAdmin funcionesAdmin) {
        this.FUNCIONESADMIN = funcionesAdmin;
    }
    
    
    protected JTextField[] getOpcionesTextField() {
        
        JTextField[] opcionesTextField = new JTextField[4];
        opcionesTextField[0] = FUNCIONESADMIN.getTxtOpcion1();
        opcionesTextField[1] = FUNCIONESADMIN.getTxtOpcion2();
        opcionesTextField[2] = FUNCIONESADMIN.getTxtOpcion3();
        opcionesTextField[3] = FUNCIONESADMIN.getTxtOpcion4();
        
        return opcionesTextField;
    }


    protected JRadioButton[] getOpcionesRadioButton() {
        
        JRadioButton[] botonOpciones = new JRadioButton[4];
        botonOpciones[0] = FUNCIONESADMIN.getRbtnOpcion1();
        botonOpciones[1] = FUNCIONESADMIN.getRbtnOpcion2();
        botonOpciones[2] = FUNCIONESADMIN.getRbtnOpcion3();
        botonOpciones[3] = FUNCIONESADMIN.getRbtnOpcion4();
        
        return botonOpciones;
    }
    
    
    
}
