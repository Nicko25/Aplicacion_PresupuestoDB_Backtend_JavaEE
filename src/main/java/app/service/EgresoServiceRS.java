package app.service;

import app.data.EgresoDao;
import app.domain.Egreso;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Stateless
@Path("/egresos")
public class EgresoServiceRS {
    
    @Inject
    private EgresoDao egresoDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Egreso> listarEgresos(){
        List<Egreso> egresos =  egresoDao.encontrarTodosEgresos();
        System.out.println("egresos encontradas:" + egresos);
        return egresos;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /egresos/{id}, ej. /egresos/1
    public Egreso encontrarEgreso(@PathParam("id") int id){
        Egreso egreso = egresoDao.encontrarEgreso(new Egreso(id));
        System.out.println("egreso encontrada:" + egreso);
        return egreso;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Egreso agregarEgreso(Egreso egreso){
        egresoDao.insertarEgreso(egreso);
        System.out.println("egreso agregada:" + egreso);
        return egreso;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarEgreso(@PathParam("id") int id, Egreso egresoModificada){
        Egreso egreso = egresoDao.encontrarEgreso(new Egreso(id));
        if(egreso != null){
            egresoDao.actualizarEgreso(egresoModificada);
            System.out.println("egreso modificada:" + egresoModificada);
            return Response.ok().entity(egresoModificada).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarEgreso(@PathParam("id") int id){
        egresoDao.eliminarEgreso(new Egreso(id));
        System.out.println("egreso eliminada con el id:" + id);
        return Response.ok().build();
    }
    
}
