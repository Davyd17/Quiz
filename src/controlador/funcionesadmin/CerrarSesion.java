package controlador.funcionesadmin;


import java.awt.event.MouseEvent;
import vista.FuncionesAdmin;
import vista.Principal;

public class CerrarSesion {
    
    private final FuncionesAdmin FUNCIONESADMIN;
    private final Principal PRINCIPAL;
    

    public CerrarSesion(FuncionesAdmin funcionesAdmin) {
        this.FUNCIONESADMIN = funcionesAdmin;
        PRINCIPAL = new Principal();
    }

    public void mouseClicked(MouseEvent e) {
        Principal.setInfoAdmin(null);
        this.FUNCIONESADMIN.dispose();
        this.PRINCIPAL.setVisible(true);
    }

}
