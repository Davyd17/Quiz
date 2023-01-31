package negocio;

import datos.administradordao.AdministradorCrud;
import datos.jugadordao.JugadorCrud;
import datos.usuariodao.ExistenciaUsuario;
import datos.usuariodao.UsuarioCrud;
import datos.usuariodao.UsuarioInicioSesion;
import entidades.Administrador;
import entidades.Jugador;
import entidades.Usuario;
import mapper.AdminMapper;
import mapper.JugadorMapper;
import transferobject.AdminDto;
import transferobject.JugadorDto;
import transferobject.UsuarioDto;

import javax.swing.*;

public class UsuarioControl {

    private final UsuarioCrud DATOS;
    private Usuario usuario;
    private UsuarioDto usuarioDto;

    public UsuarioControl() {
        DATOS = new UsuarioCrud();
        usuario = new Usuario();
    }

    public String registrar(String nombreUsuario, String contrasena, int rol) {

        ExistenciaUsuario existencia = new ExistenciaUsuario();

        if (existencia.encontrar(nombreUsuario)) {
            return "El usuario ya existe";
        } else {

            this.usuario.setNombreUsuario(nombreUsuario);
            this.usuario.setContrasena(contrasena);
            this.usuario.setRol(rol);

            if (DATOS.insertar(this.usuario)) {
                return "OK";
            } else {
                return "No fue posible realizar el registro";
            }
        }

    }

    public UsuarioDto IniciarSesion(String nombreUsuario, String contrasena){

        UsuarioInicioSesion logIn = new UsuarioInicioSesion();

        this.usuario = logIn.iniciarSesion(nombreUsuario,contrasena);

        if(this.usuario != null){
            if(this.usuario.getRol() == 1){

                Administrador administrador = new AdministradorCrud().obtener(this.usuario.getId());

                this.usuarioDto = new AdminMapper().CreateDTO(administrador,this.usuario);

            } else if (this.usuario.getRol() == 2) {

                Jugador jugador = new JugadorCrud().obtener(this.usuario.getId());

                this.usuarioDto = new JugadorMapper().CreateDTO(jugador, this.usuario);
            }
        }

        return usuarioDto;
    }

    public static void main(String[] args) {

        UsuarioControl usuarioControl = new UsuarioControl();
        System.out.println(usuarioControl.registrar("prueba13","123",2));
    }

}