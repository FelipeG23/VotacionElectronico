package Servicios;

import DAO.CampanaDAO;
import Entities.CampanaEntity;
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
 * @author santi
 */
@Path("CampanasService")
@Stateless
@WebService
public class CampanasService {

    @GET
    @Path("consultarTodosCampanas/")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarTodosCampanas() {
        String objJson = "";

        try {
            CampanaDAO campanaDAO = new CampanaDAO();
            List<CampanaEntity> campanas = campanaDAO.consultarCampanas();
            if (!campanas.isEmpty()) {
                objJson = DeserializaObjeto.creaObjetoJson("OK", campanas);
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
