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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public String consultarTodosVotantes() {
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

    @GET
    @Path("validarVotante/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public String validarVotante(@PathParam("cedula") String cedula) {
        String objJson = "";
        try {
            VotantesDAO dao = new VotantesDAO();
            String valida = dao.validarVotante(cedula);
            if (valida.equalsIgnoreCase("OK")) {
                objJson = DeserializaObjeto.creaObjetoJson("OK", "OK");
            } else {
                objJson = DeserializaObjeto.creaObjetoJson("ERROR", valida);
            }
        } catch (Exception e) {
            e.printStackTrace();
            objJson = DeserializaObjeto.creaObjetoJson("ERROR", "NO SE ENCONTRARON RESULTADOS");
        }
        return objJson;
    }
    
    @POST
    @Path("guardarVoto/{cedula}/{idCandidato}/{idPuesto}")
    @Produces(MediaType.APPLICATION_JSON)
    public String guardarVoto(@PathParam("cedula") String cedula,@PathParam("idCandidato") String idCandidato,
                                @PathParam("idPuesto") String idPuesto
    ) {
        String objJson = "";
        try {
            VotantesDAO dao = new VotantesDAO();
            String valida = dao.guardarVoto(cedula, idCandidato, idPuesto);
            if (valida.equalsIgnoreCase("OK")) {
                objJson = DeserializaObjeto.creaObjetoJson("OK", "VOTO GUARDADO CORRECTAMENTE");
            } else {
                objJson = DeserializaObjeto.creaObjetoJson("ERROR", valida);
            }
        } catch (Exception e) {
            e.printStackTrace();
            objJson = DeserializaObjeto.creaObjetoJson("ERROR", "NO SE ENCONTRARON RESULTADOS");
        }
        return objJson;
    }
}
