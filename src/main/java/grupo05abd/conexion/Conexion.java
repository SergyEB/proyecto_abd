package grupo05abd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;

public class Conexion {
    static Connection connection = null;
    
    static String user = "sa";
    static String pass = "12345";
    static String db = "Grupo5_IF51002025";
    static String ip = "localhost";
    static String port = "1433";
                 
    public static Connection getConnection(){
    try{
        //String cadena = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+db;
        //conexion = DriverManager.getConnection(cadena, user, pass);
        
        // jdbc:sqlserver://localhost:1433;databaseName=tuBaseDeDatos;user=tuUsuario;password=tuContraseña;encrypt=true;trustServerCertificate=true;
        
        String cadena = "jdbc:sqlserver://"+ip+":"+port+";databaseName="+db+
                ";user="+user+";password="+pass+";encrypt=true;trustServerCertificate=true";
        connection = DriverManager.getConnection(cadena);
        JOptionPane.showMessageDialog(null, "Conexion Exitosa a la Base de Datos");
        
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error: "+e.toString());
    }
    return connection;
}
}

