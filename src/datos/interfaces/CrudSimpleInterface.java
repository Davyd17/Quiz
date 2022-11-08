package datos.interfaces;

import java.util.List;

//Interfaz que integra el CRUD para interactuar con la base de datos
//No se integra DELETE ya que en el programa no se podran eliminar datos

public interface CrudSimpleInterface<T>{

    public List<T> listar(int index);
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean existe(String texto);
}
