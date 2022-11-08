package negocio.usuario;

import datos.UsuarioDAO;
import entidades.Usuario;

public class Registro{

    private final UsuarioDAO DATOS;
    private final Usuario OBJ;

    public Registro(){
        DATOS = new UsuarioDAO();
        OBJ = new Usuario();
    }

    public String registrar(String usuario,String contraseña) {
        String resp = "0";
        Usuario usuario = this.DATOS.insertar()


    }


}
