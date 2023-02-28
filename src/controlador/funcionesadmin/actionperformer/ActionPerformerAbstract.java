/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin.actionperformer;

import controlador.funcionesadmin.AccesoComponentes;
import controlador.funcionesadmin.AdminInfoControl;
import controlador.funcionesadmin.ControlCampos;
import controlador.funcionesadmin.AdminInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FuncionesAdmin;

public abstract class ActionPerformerAbstract implements ActionListener{
    
    private final FuncionesAdmin FUNCIONES_ADMIN;
    private final AdminInfo SHOW_INFO;
    private final AccesoComponentes ACCESO_COMPONENTES;
    private final ControlCampos CONTROL_CAMPOS;
    private final AdminInfoControl INFO_CONTROL;

    public ActionPerformerAbstract(FuncionesAdmin FUNCIONES_ADMIN) {
        this.FUNCIONES_ADMIN = FUNCIONES_ADMIN;
        this.SHOW_INFO = new AdminInfo(FUNCIONES_ADMIN);
        this.ACCESO_COMPONENTES = new AccesoComponentes(FUNCIONES_ADMIN);
        this.CONTROL_CAMPOS = new ControlCampos(FUNCIONES_ADMIN);
        this.INFO_CONTROL = new AdminInfoControl(FUNCIONES_ADMIN);
    }

    
    @Override
    public abstract void actionPerformed(ActionEvent e);

    public AdminInfo getSHOW_INFO() {
        return SHOW_INFO;
    }

    public AccesoComponentes getACCESO_COMPONENTES() {
        return ACCESO_COMPONENTES;
    }

    public ControlCampos getCONTROL_CAMPOS() {
        return CONTROL_CAMPOS;
    }

    public AdminInfoControl getINFO_CONTROL() {
        return INFO_CONTROL;
    }
    
    
    
    
    
}
