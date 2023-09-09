package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class AACordenadaDAC extends SQLiteDataHelper {

    /** 
     * Establece la conexión con la base de datos.
     * */ 
    public ResultSet aaGetAllData() throws AppException{
        String query =   "SELECT c.TipoArsenal, f.Coordenadas, d.Arsenal, b.Dias, e.Hora"
        + " FROM AA_COORDENADAS_UCRANIANAS a"
        + " JOIN AA_TIPO_ARSENAL c ON a.IdTipoArsenal = c.IdTipoArsenal"
        + " JOIN AA_COORDENADAS f ON a.IdCoordenadas = f.IdCoordenadas"
        + " JOIN AA_ARSENAL d ON a.IdArsenal = d.IdArsenal"
        + " JOIN AA_DIAS b ON a.IdDias = b.IdDias"
        + " JOIN AA_HORA e ON a.IdHora = e.IdHora";

        try{
            Connection conn = openConnection();
            Statement stmt  = conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch(SQLException e){
            throw new AppException(e, getClass(),"getAllData");
        }
    
    }
    
}
