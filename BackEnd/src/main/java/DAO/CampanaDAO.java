package DAO;

import Conexion.Conexion;
import Entities.CampanaEntity;
import java.sql.Connection;
import java.sql.Date;
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

    public boolean establecerCalendario(int idCampana, String nombreCampana, int yearInicio, int monthInicio, int dayInicio, int yearFin, int monthFin, int dayFin) {
        Date fechaInicio = new Date(yearInicio, monthInicio, dayInicio);
        Date fechaFin = new Date(yearFin, monthFin, dayFin);
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        PreparedStatement ps = null;

        try {
            conn = Conexion.GetConnection();
            sql.append(" INSERT INTO CAMPANA ");
            sql.append(" (ID_CAMPANA, NOMBRE_CAMPANA, FECHA_INICIO, FECHA_FIN) ");
            sql.append(" VALUES(?,?,?,?) ");

            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, idCampana);
            ps.setString(2, nombreCampana);
            ps.setDate(3, fechaInicio);
            ps.setDate(4, fechaFin);

            return ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

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
