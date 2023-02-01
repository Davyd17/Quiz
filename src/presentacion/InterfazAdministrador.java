package presentacion;

import javax.swing.*;
import java.awt.event.*;

public class InterfazAdministrador extends JFrame{
    private JPanel pnlAdmin;
    private JLabel label;

    public InterfazAdministrador(){
        super("Interfaz administrador");
        this.setContentPane(pnlAdmin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUIComponents();

    }

    private void createUIComponents() {
        this.setSize(500,430);
        this.setLocationRelativeTo(null);

    }

}
