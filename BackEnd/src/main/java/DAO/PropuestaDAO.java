package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import Entities.PropuestaEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class PropuestaDAO {

    public List<PropuestaEntity> consultarPropuestasCandidato(int idCandidato) {
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PropuestaEntity> propuestasCandidato = new ArrayList<>();

        try {
            conn = Conexion.GetConnection();

            sql.append(" SELECT ");
            sql.append(" ID_PROPUESTA, DESCRIPCION_PROPUESTA ");
            sql.append(" FROM PROPUESTA ");
            sql.append(" WHERE ID_CANDIDATO = ? ");

            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, idCandidato);

            rs = ps.executeQuery();
            
            while (rs.next()) {                
                PropuestaEntity aux = new PropuestaEntity();
                aux.setIdPropuesta(rs.getInt("ID_PROPUESTA"));
                aux.setDescripcionPropuesta(rs.getString("DESCRIPCION_PROPUESTA"));
                
                propuestasCandidato.add(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return propuestasCandidato;
    }

}
