package app.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import app.domain.Ingreso;
import app.data.IngresoDao;


@Stateless
@Path("/ingresos")
public class IngresoServiceRS {
    
    @Inject
    private IngresoDao ingresoDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Ingreso> listarIngresos(){
        List<Ingreso> ingresos =  ingresoDao.encontrarTodosIngresos();
        System.out.println("ingresos encontradas:" + ingresos);
        return ingresos;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /ingresos/{id}, ej. /ingresos/1
    public Ingreso encontrarIngreso(@PathParam("id") int id){
        Ingreso ingreso = ingresoDao.encontrarIngreso(new Ingreso(id));
        System.out.println("ingreso encontrada:" + ingreso);
        return ingreso;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ingreso agregarIngreso(Ingreso ingreso){
        ingresoDao.insertarIngreso(ingreso);
        System.out.println("ingreso agregada:" + ingreso);
        return ingreso;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarIngreso(@PathParam("id") int id, Ingreso ingresoModificada){
        Ingreso ingreso = ingresoDao.encontrarIngreso(new Ingreso(id));
        if(ingreso != null){
            ingresoDao.actualizarIngreso(ingresoModificada);
            System.out.println("ingreso modificada:" + ingresoModificada);
            return Response.ok().entity(ingresoModificada).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarIngreso(@PathParam("id") int id){
        ingresoDao.eliminarIngreso(new Ingreso(id));
        System.out.println("ingreso eliminada con el id:" + id);
        return Response.ok().build();
    }
    
}