package negocio;

import datos.UsuarioDAO;
import entidades.Administrador;
import entidades.Jugador;
import entidades.Usuario;
import mapper.AdminMapper;
import mapper.JugadorMapper;
import transferobject.AdminDTO;
import transferobject.JugadorDTO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private final Usuario OBJ;
    private final AdminMapper ADMAP;
    private final JugadorMapper JUGMAP;

    public UsuarioControl(){
        DATOS = new UsuarioDAO();
        OBJ = new Usuario();
        ADMAP = new AdminMapper();
        JUGMAP = new JugadorMapper();
    }

    public String registrar(String usuario,String contrasena, int rol) {

        if(DATOS.existe(usuario)){
            return "El usuario ya existe";
        } else {

            OBJ.setNombreUsuario(usuario);
            OBJ.setContrasena(contrasena);
            OBJ.setRol(rol);

            if(DATOS.insertar(OBJ)){
                return "OK";
            } else {
                return "No fue posible realizar el registro";
            }
        }

    }

    public List<String> inciarSesion(String nombreUsuario, String contrasena){


        List<String> info = new ArrayList<>();

        Usuario usuario = DATOS.iniciarSesion(nombreUsuario,contrasena);

        if(usuario != null) {
            if (usuario.equals(new Administrador())) {
                AdminDTO adminDTO = ADMAP.CreateDTO((Administrador) usuario);
                info.add(Integer.toString(adminDTO.getUsuarioId()));
                info.add(Integer.toString(adminDTO.getAdminId()));
                info.add(adminDTO.getNombre_usuario());

            } else {
                JugadorDTO jugadorDTO = JUGMAP.CreateDTO((Jugador) usuario);
                info.add(Integer.toString(jugadorDTO.getUsuarioId()));
                info.add((Integer.toString(jugadorDTO.getJugadorId())));
                info.add(jugadorDTO.getNombreUsuario());
                info.add((Integer.toString(jugadorDTO.getNivelId())));
                info.add((Integer.toString(jugadorDTO.getPuntosAcumulados())));

            }
        }


        return info;
        }

    public static void main(String[] args) {
        UsuarioControl usuarioControl = new UsuarioControl();
        System.out.println(usuarioControl.inciarSesion("prueba", "123"));
    }


    }
