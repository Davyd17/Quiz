package mapper;

import entidades.Administrador;
import transferobject.AdminDTO;

public class AdminMapper {

    public AdminDTO CreateDTO(Administrador administrador){

        AdminDTO adminDTO = new AdminDTO(
                administrador.getUsuarioId(),
                administrador.getAdminId(),
                administrador.getNombreUsuario()
        );

        return adminDTO;
    }
}
