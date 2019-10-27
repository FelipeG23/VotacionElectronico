package DAO;

import Conexion.Conexion;
import Entities.CampanaEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class CampanaDAO {

    public CampanaEntity consultarCampana(int idCampana) {
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        PreparedStatement stm = null;
        ResultSet rs = null;
        CampanaEntity campana = new CampanaEntity();
        try {
            conn = Conexion.GetConnection();

            sql.append(" SELECT ");
            sql.append(" ID_CAMPANA, NOMBRE_CAMPANA, FECHA_INICIO, FECHA_FIN ");
            sql.append(" FROM CAMPANA ");
            sql.append(" WHERE ID_CAMPANA = ? ");

            stm = conn.prepareStatement(sql.toString());
            stm.setInt(1, idCampana);

            rs = stm.executeQuery();

            if (rs.next()) {
                campana.setIdCampana(idCampana);
                campana.setNombreCampana(rs.getString("NOMBRE_CAMPANA"));
                campana.setFechaInicio(rs.getDate("FECHA_INICIO"));
                campana.setFechaFin(rs.getDate("FECHA_FIN"));
            } else {
                throw new Exception("No existe la campaña");
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
        return campana;
    }

    public List<CampanaEntity> consultarCampanas() {
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        Statement stm = null;
        ResultSet rs = null;

        List<CampanaEntity> campanas = new ArrayList<>();
        try {
            conn = Conexion.GetConnection();

            sql.append(" SELECT ");
            sql.append(" ID_CAMPANA, NOMBRE_CAMPANA, FECHA_INICIO, FECHA_FIN ");
            sql.append(" FROM CAMPANA ");

            stm = conn.createStatement();

            rs = stm.executeQuery(sql.toString());

            while (rs.next()) {
                CampanaEntity aux = new CampanaEntity();

                aux.setIdCampana(rs.getInt("ID_CAMPANA"));
                aux.setNombreCampana(rs.getString("NOMBRE_CAMPANA"));
                aux.setFechaInicio(rs.getDate("FECHA_INICIO"));
                aux.setFechaFin(rs.getDate("FECHA_FIN"));

                campanas.add(aux);
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
        return campanas;
    }
}
