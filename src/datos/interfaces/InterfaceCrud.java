package datos.interfaces;

//Interfaz que integra el CRUD para interactuar con la base de datos
//No se integra DELETE ya que en el programa no se podran eliminar datos

public interface InterfaceCrud<T>{

    public boolean insertar(T obj);
    public T obtener(int id);
    public boolean actualizar(T obj);
}
