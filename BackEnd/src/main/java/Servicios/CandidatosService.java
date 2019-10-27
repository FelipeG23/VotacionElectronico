/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.CandidatosDAO;
import Entities.CandidatoEntity;
import Utiles.DeserializaObjeto;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author santi
 */
@Path("CandidatosService")
@Stateless
@WebService
public class CandidatosService {

//    @GET
//    @Path("consultarTodosCandidatos/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String consultarCandidatos(@PathParam("id") String id) {
    
    @GET
    @Path("consultarTodosCandidatos/")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarCandidatos() {
        String objJson = "";
        try {
            CandidatosDAO candidatos = new CandidatosDAO();
            List<CandidatoEntity> lista = candidatos.consultarTodosCandidatos();

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
