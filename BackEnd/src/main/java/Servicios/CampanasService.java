package Servicios;

import DAO.CampanaDAO;
import Entities.CampanaEntity;
import Utiles.DeserializaObjeto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        CampanaDAO campanaDAO = new CampanaDAO();
        List<CampanaEntity> campanas = campanaDAO.consultarCampanas();

        if (!campanas.isEmpty()) {
            objJson = DeserializaObjeto.creaObjetoJson("OK", campanas);
        } else {
            objJson = DeserializaObjeto.creaObjetoJson("ERROR", "No se encontraron campañas");
        }

        return objJson;
    }

    @POST
    @Path("crearCampana/{idCampana}/{nombreCamapna}/{fechaInicio}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public String crearCampana(@PathParam("idCampana") int idCampana, @PathParam("nombreCampana") String nombreCampana, @PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin) {
        String objJson = "";
        try {
            CampanaDAO campanaDAO = new CampanaDAO();
            String formatoFecha = "dd-mm-yy";
            java.util.Date dateInicio = new SimpleDateFormat(formatoFecha).parse(fechaInicio);
            java.sql.Date sqlDateInicio = new java.sql.Date(dateInicio.getTime());
            java.util.Date dateFin = new SimpleDateFormat(formatoFecha).parse(fechaFin);
            java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());

            boolean estado = campanaDAO.crearCampana(
                    idCampana,
                    nombreCampana,
                    sqlDateInicio,
                    sqlDateFin
            );

            if (estado) {
                objJson = DeserializaObjeto.creaObjetoJson("OK", "CAMPAÑA CREADA EXITOSAMENTE");
            } else {
                objJson = DeserializaObjeto.creaObjetoJson("ERROR", "ERROR AL CREAR CAMPAÑA");
            }
        } catch (ParseException ex) {
            objJson = DeserializaObjeto.creaObjetoJson("ERROR", "ERROR AL CREAR CAMPAÑA" + ex.getMessage());
        }

        return objJson;

    }
}
