package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Constantes para la conexion
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "quiz?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "219035";

    public static Conexion instancia; //Objeto que permite aplicar una unica instancia y asi aplicar el patron Singleton

    public Connection cadena; // Variable que almacenara la conexion a mysql y la base de datos.

    private Conexion(){
        this.cadena = null;
    }

    //Metodo de tipo Connection que nos permite conectar con la base de datos
    public Connection conectar() {
        try {

            this.cadena = DriverManager.getConnection(URL + DB,USER,PASSWORD);

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0);
        }

        return this.cadena;
    }

    //Metodo para finalizar la conexion a la base de datos
    public void desconectar(){
        try {

            this.cadena.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    //Metodo que permite obtener la instancia al objeto conexion y asi aplicar el patron singleton
    public synchronized static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
