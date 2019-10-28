package Servicios;

import DAO.CampanaDAO;
import Entities.CampanaEntity;
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

    @POST
    @Path("establecerCalendario/")
    @Produces(MediaType.APPLICATION_JSON)
    public String establecerCalendario(
            @PathParam("id-campana") int idCamapna,
            @PathParam("nombre-campana") String nombreCampana,
            @PathParam("year-inicio") int yeatInicio,
            @PathParam("month-inicio") int monthInicio,
            @PathParam("day-inicio") int dayInicio,
            @PathParam("year-fin") int yearFin,
            @PathParam("month-fin") int monthFin,
            @PathParam("day-fin") int dayFin
    ) {
        return null;
    }
}
