package controlador.funcionesadmin;


import controlador.Info;
import controlador.Info;
import java.awt.event.MouseEvent;
import vista.FuncionesAdmin;
import vista.Principal;

public final class CerrarSesion {
    
    private final FuncionesAdmin FUNCIONESADMIN;
    private final Principal PRINCIPAL;
    

    public CerrarSesion(MouseEvent evt, FuncionesAdmin funcionesAdmin) {
        this.FUNCIONESADMIN = funcionesAdmin;
        PRINCIPAL = new Principal();
        this.mouseClicked(evt);
    }

    public void mouseClicked(MouseEvent e) {
        Info.setInfoAdmin(null);
        this.FUNCIONESADMIN.dispose();
        this.PRINCIPAL.setVisible(true);
    }

}
