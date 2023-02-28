package modelo.negocio;

// Clase NivelControl encargada de interactuar y controlar el CRUD del objeto Nivel
import modelo.datos.mysql.MySQLNivelDAO;

import modelo.entidades.Nivel;
import modelo.mapper.NivelMapper;

import modelo.transferobject.NivelDto;

public class NivelControl {

    private final MySQLNivelDAO DATOS;
    private Nivel entidad;
    private NivelDto nivelDto;
    private boolean resp;

    public NivelControl() {
        DATOS = new MySQLNivelDAO();
    }

    public NivelDto obtener(int nivel) {

        if (DATOS.existe(nivel)) {
            nivelDto = new NivelMapper().CreateDTO(DATOS.obtener(nivel), new PreguntaControl().obtenerListaDePreguntasPorNivelId(DATOS.obtener(nivel).getId()));
        }

        return nivelDto;
    }

    public boolean insertar(int nivel, String categoria, int puntos, String dificultad) {

        entidad = new Nivel();
        entidad.setNivel(nivel);
        entidad.setCategoria(categoria);
        entidad.setPuntos(puntos);
        entidad.setDificultad(dificultad);

        resp = DATOS.insertar(entidad);

        return resp;
    }

    public boolean editar(int nivel, String categoria, int puntos, String dificultad) {

        entidad = new Nivel();
        entidad.setNivel(nivel);
        entidad.setCategoria(categoria);
        entidad.setPuntos(puntos);
        entidad.setDificultad(dificultad);

        resp = DATOS.actualizar(entidad);

        return resp;
    }

}
