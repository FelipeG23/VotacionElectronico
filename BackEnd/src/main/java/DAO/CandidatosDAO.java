package DAO;

import Conexion.Conexion;
import Entities.CampanaEntity;
import Entities.CandidatoEntity;
import Entities.PropuestaEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class CandidatosDAO {

    public List<CandidatoEntity> consultarTodosCandidatos() {
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        Statement stm = null;
        ResultSet rs = null;
        List<CandidatoEntity> candidatos = new ArrayList<>();
        try {
            conn = Conexion.GetConnection();

            sql.append(" SELECT ");
            sql.append(" ID_CANDIDATO, NOMBRE_CANDIDATO, ID_CAMPANA ");
            sql.append(" FROM CANDIDATO ");

            stm = conn.createStatement();

            rs = stm.executeQuery(sql.toString());

            while (rs.next()) {
                CandidatoEntity aux = new CandidatoEntity();
                aux.setId(rs.getInt("ID_CANDIDATO"));
                aux.setNombreCandidato(rs.getString("NOMBRE_CANDIDATO"));

                CampanaDAO campanaDAO = new CampanaDAO();
                CampanaEntity campana = campanaDAO.consultarCampana(rs.getInt("ID_CAMPANA"));
                aux.setCampana(campana);

                PropuestaDAO propuestaDAO = new PropuestaDAO();
                aux.setPropuestas(propuestaDAO.consultarPropuestasCandidato(rs.getInt("ID_CANDIDATO")));
                candidatos.add(aux);
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
        return candidatos;
    }
}
