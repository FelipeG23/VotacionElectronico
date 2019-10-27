package Entities;

import java.util.List;

/**
 *
 * @author santi
 */
public class CandidatoEntity {

    private Integer id;
    private String nombreCandidato;
    private CampanaEntity campana;
    private List<PropuestaEntity> propuestas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public CampanaEntity getCampana() {
        return campana;
    }

    public void setCampana(CampanaEntity campana) {
        this.campana = campana;
    }

    public List<PropuestaEntity> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List<PropuestaEntity> propuestas) {
        this.propuestas = propuestas;
    }

}
