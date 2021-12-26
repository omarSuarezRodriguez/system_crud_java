package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar
 */
public class conexion {
    
    // Ubicación de la base de datos dentro de la app de java, en la raiz del proyecto
    // ó
    // debemos poner este archivo al lado del .jar creado para que la bd funcione
    String strConexionDB = "jdbc:sqlite:file:sistema.s3db";
    //String strConexionDB = "jdbc:sqlite:C:/Users/Omar/Documents/db/sistema.s3db";
    Connection conn = null;
    
    
    public conexion () {
        
        try {
            
            Class.forName("org.sqlite.JDBC");
            
            conn = DriverManager.getConnection(strConexionDB);
            
            
            System.out.println("Conexión establecida");
            
            
            
            
            
        } catch (Exception e) {
            
            System.out.println("Error conexión " + e);
            
        }
        
    }
    
    
    
    // Metodo para ejecutar sentencia
    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
            
        }
        
    }
    
    
    
    // Método para consultar registros
    public ResultSet consultarRegistros(String strSentenciaSQL) {
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
            
        } catch (Exception e) {
            
            System.out.println(e);
            return null;
            
        }
        
        
    }
    
    
    
    
} // Fin clase
