/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entities.AplicacionEntity;
import Entities.VotantesEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class VotantesDAO {

    public List<VotantesEntity> consultarVotantes() {
        Connection conn = null;
        List<VotantesEntity> lista = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("	SELECT                                          ");
            sql.append("	ID_VOTANTE, NOMBRE_VOTANTE, CEDULA_VOTANTE,     ");
            sql.append("	   ID_CAMPANA                                   ");
            sql.append("	FROM VOTO.VOTANTE				");
            conn = Conexion.GetConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql.toString());
            while (rs.next()) {
                if (lista.isEmpty()) {
                    lista = new ArrayList<>();
                }
                VotantesEntity aux = new VotantesEntity();
                aux.setId_Votante(rs.getInt("ID_VOTANTE"));
                aux.setNombre_Votante(rs.getString("NOMBRE_VOTANTE"));
                aux.setCedula_Votante(rs.getString("CEDULA_VOTANTE"));
                lista.add(aux);
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
        return lista;
    }
}
