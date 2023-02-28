package controlador;

import controlador.Info;
import vista.FuncionesAdmin;
import vista.Juego;
import vista.Principal;

public final class CierreSesion {
    
    private final Principal PRINCIPAL;
    

    public CierreSesion() {
        PRINCIPAL = new Principal();
    }
    
    public void finalizar(Juego juego) {
        Info.setInfoAdmin(null);
        juego.dispose();
        this.PRINCIPAL.setVisible(true);
    }
    
    public void finalizar(FuncionesAdmin funcionesAdmin) {
        Info.setInfoAdmin(null);
        funcionesAdmin.dispose();
        this.PRINCIPAL.setVisible(true);
    }

}
