package modelo.negocio;

// Clase NivelControl encargada de interactuar y controlar el CRUD del objeto Nivel
import modelo.datos.mysql.MySQLNivelDAO;

import modelo.entidades.Nivel;
import modelo.entidades.Opcion;
import modelo.mapper.NivelMapper;

import modelo.transferobject.NivelDto;
import modelo.transferobject.PreguntaDto;

import java.util.ArrayList;
import java.util.List;

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
            nivelDto = new NivelMapper().CreateDTO(DATOS.obtener(nivel), new PreguntaControl().obtenerListaPorNivel(DATOS.obtener(nivel).getId()));
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

    public static void main(String[] args) {

        NivelControl nivelControl = new NivelControl();

        int nivel = 1;

        NivelDto nivelDto = nivelControl.obtener(nivel);

        if (nivelDto != null) {

            System.out.println("Nivel: " + nivelDto.getNivel() + " Categoria: " + nivelDto.getCategoria() + " Puntos: " + nivelDto.getPuntos());

            ArrayList<PreguntaDto> preguntaDtos = nivelDto.getPreguntas();

            PreguntaDto preguntaDto = preguntaDtos.get((int) (Math.random() * preguntaDtos.size()));

            System.out.println("\n" + preguntaDto.getContenido() + "\n");

            for (Opcion opcion : new ArrayList<>(preguntaDto.getOpciones())) {

                System.out.println(opcion.getContenido() + "   " + opcion.isRespuesta());

            }

        } else {

            nivelControl.insertar(1, "Primera", 50, "Facil");

            PreguntaControl preguntaControl = new PreguntaControl();

            preguntaControl.insertar(nivel, "La mera pregunta");

            nivelDto = nivelControl.obtener(nivel);

            List<PreguntaDto> preguntaDtos = nivelDto.getPreguntas();

            for (PreguntaDto preguntaDto : preguntaDtos) {

                int preguntaId = preguntaDto.getPreguntaId();

                System.out.println(preguntaId);
                OpcionControl opcionControl = new OpcionControl();

                opcionControl.insertar(preguntaId, "A", true);
                opcionControl.insertar(preguntaId, "B", false);
                opcionControl.insertar(preguntaId, "C", false);
                opcionControl.insertar(preguntaId, "D", false);
            }

            nivelDto = nivelControl.obtener(nivel);

            System.out.println(nivelDto);

        }

    }
}
