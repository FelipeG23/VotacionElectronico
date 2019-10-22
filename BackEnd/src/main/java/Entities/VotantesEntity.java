/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Felipe
 */
public class VotantesEntity {

    private Integer id_Votante;
    private String nombre_Votante;
    private String cedula_Votante;
    private CampanaEntity Campana;

    public Integer getId_Votante() {
        return id_Votante;
    }

    public void setId_Votante(Integer id_Votante) {
        this.id_Votante = id_Votante;
    }

    public String getNombre_Votante() {
        return nombre_Votante;
    }

    public void setNombre_Votante(String nombre_Votante) {
        this.nombre_Votante = nombre_Votante;
    }

    public String getCedula_Votante() {
        return cedula_Votante;
    }

    public void setCedula_Votante(String cedula_Votante) {
        this.cedula_Votante = cedula_Votante;
    }

    public CampanaEntity getCampana() {
        return Campana;
    }

    public void setCampana(CampanaEntity Campana) {
        this.Campana = Campana;
    }

}
