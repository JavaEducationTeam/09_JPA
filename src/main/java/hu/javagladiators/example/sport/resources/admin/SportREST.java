package hu.javagladiators.example.sport.resources.admin;


import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.services.api.SportService;
import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import hu.javagladiators.example.sport.viewmodel.system.MessagePOJO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionPOJO;
import hu.javagladiators.example.sport.viewmodel.BasicEntitiesDTO;
import hu.javagladiators.example.sport.viewmodel.system.PagerPOJO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Path("/sport")
@Api(value = "Sportágak adminisztrációja")
@PermitAll
public class SportREST {
    Logger log = LoggerFactory.getLogger(SportREST.class.getSimpleName());
    
    @Inject
    SportService service;

    @Inject
    BasicEntitiesDTO dtoBasicIdNameDescription;
    
    public SportREST() {
    }

    @GET
    @Path("/entity/page") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiOperation(value = "Listázs")
    public PagerPOJO entityList(
            @ApiParam(value = "Rendezés asc/desc")   @QueryParam("order")  @DefaultValue("asc") String order, 
            @ApiParam(value = "Első elem poziciója") @QueryParam("offset") @DefaultValue("0")   long offset, 
            @ApiParam(value = "Darabszám")           @QueryParam("limit")  @DefaultValue("10")  long limit
    ){
        PagerPOJO res = new PagerPOJO();
        res.setTotal(service.getAll().size());
        List data = new ArrayList();
       for(long i=offset;i<(offset+limit) && i<service.getAll().size();i++)
            data.add(service.getAll().get((int)i));
        res.setRows(data);
        return res;
    }
    
    @GET
    @Path("/entity/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Sport> entityList(){
        return service.getAll();
    }

    @GET
    @Path("/idname/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<IdNamePOJO> idnemeList(){
        List<IdNamePOJO> res = new ArrayList<>();
        List<Sport> entities = service.getAll();
        for(Sport entity : entities)
            res.add(IdNamePOJO.factoryDTO(entity));
        return res;
    }

    @GET
    @Path("namedescription/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<NameDescriptionPOJO> nemedescriptionList(){
        List<NameDescriptionPOJO> res = new ArrayList<>();
        List<Sport> entities = service.getAll();
        for(Sport entity : entities)
            res.add(dtoBasicIdNameDescription.factory(entity));
        return res;
    }
    
    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiOperation(value = "This method allows to retrieve a certain sport.")    
    public Sport findById(@PathParam("id") int id){
        return service.getById(id);
    }


    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @RolesAllowed(value = {"manager"})
    public MessagePOJO save(@Context SecurityContext sc, NameDescriptionPOJO pSport){
        log.info(sc.getUserPrincipal().getName()+":"+sc.isUserInRole("manager"));
        service.save(dtoBasicIdNameDescription.toSport(pSport));
        return new MessagePOJO("OK");
    }
    
}
