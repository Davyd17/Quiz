package modelo.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    
    // Constantes para la conexion
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "quiz?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "219035";

    public static ConexionMySQL instancia; //Variable que permite aplicar una unica instancia y asi aplicar el patron Singleton

    public Connection cadena; // Variable que almacenara la conexion a mysql y la base de datos.

    private ConexionMySQL(){
        this.cadena = null;
    }

    //Metodo que nos permite conectar con la base de datos
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

    //Metodo que permite obtener la instancia a la variable conexion y asi aplicar el patron singleton
    public synchronized static ConexionMySQL getInstance(){
        if(instancia == null){
            instancia = new ConexionMySQL();
        }
        return instancia;
    }
}
