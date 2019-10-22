/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.VotantesDAO;
import Entities.VotantesEntity;
import Utiles.DeserializaObjeto;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Felipe
 */
@Path("VotantesService")
@Stateless
@WebService
public class VotantesService {

    @GET
    @Path("consultarTodosVotantes/")
    @Produces(MediaType.APPLICATION_JSON)
    public String actualizarSalonHorario() {
        String objJson = "";
        try {
            VotantesDAO dao = new VotantesDAO();
            List<VotantesEntity> lista = dao.consultarVotantes();
            if (!lista.isEmpty()) {
                objJson = DeserializaObjeto.creaObjetoJson("OK", lista);
            } else {
                objJson = DeserializaObjeto.creaObjetoJson("ERROR", "NO SE ENCONTRARON RESULTADOS");
            }
        } catch (Exception e) {
            e.printStackTrace();
            objJson = DeserializaObjeto.creaObjetoJson("ERROR", "NO SE ENCONTRARON RESULTADOS");
        }
        return objJson;
    }
}
