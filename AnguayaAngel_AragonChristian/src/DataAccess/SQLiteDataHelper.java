package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Framework.AppException;

public abstract class SQLiteDataHelper {
    
    private static String DBPathConnection = "jdbc:sqlite:database\\AADatos.db"; //null;
    private static Connection conn = null;
    public SQLiteDataHelper(){
    }
    
    /** 
     * Abre la conexión.
     * */ 
    protected static synchronized Connection openConnection() throws AppException{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            throw new AppException(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return conn;
    }
    /*
     * Cierra la conexión.
     */
    protected static void closeConnection() throws AppException{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new AppException(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}
