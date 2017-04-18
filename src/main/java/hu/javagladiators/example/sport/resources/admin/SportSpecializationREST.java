package hu.javagladiators.example.sport.resources.admin;




import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import hu.javagladiators.example.sport.services.api.SportService;
import hu.javagladiators.example.sport.services.api.SportSpecializationService;
import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import hu.javagladiators.example.sport.viewmodel.system.MessagePOJO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionPOJO;
import hu.javagladiators.example.sport.viewmodel.BasicEntitiesDTO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionParendIDPOJO;
import io.swagger.annotations.Api;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Path("/sportspecialization")
@Api(value = "Sports specialization administration")
@PermitAll
public class SportSpecializationREST {
    Logger log = LoggerFactory.getLogger(SportSpecializationREST.class.getSimpleName());
    
    @Inject
    SportSpecializationService service;
    @Inject
    SportService serviceSport;

    @Inject
    BasicEntitiesDTO dtoBasicIdNameDescription;
    
    public SportSpecializationREST() {
    }

    @GET
    @Path("/entity/{sportid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<SportSpecialization> entityList(@PathParam("sportid") int id){
        return service.getAllForSport(serviceSport.getById(id));
    }

    @GET
    @Path("/idname/{sportid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<IdNamePOJO> idnemeList(@PathParam("sportid") int id){
        List<IdNamePOJO> res = new ArrayList<>();
        List<SportSpecialization> entities = service.getAllForSport(serviceSport.getById(id));
        for(SportSpecialization entity : entities)
            res.add(IdNamePOJO.factoryDTO(entity));
        return res;
    }

    @GET
    @Path("/namedescription/{sportid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<NameDescriptionPOJO> nemedescriptionList(@PathParam("sportid") int id){
        List<NameDescriptionPOJO> res = new ArrayList<>();
        List<SportSpecialization> entities = service.getAllForSport(serviceSport.getById(id));
        for(SportSpecialization entity : entities)
            res.add(dtoBasicIdNameDescription.factory(entity));
        return res;
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @RolesAllowed(value = {"manager"})
    public MessagePOJO save(@Context SecurityContext sc, NameDescriptionParendIDPOJO pSport){
        log.info(sc.getUserPrincipal().getName()+":"+sc.isUserInRole("manager"));
        service.save(dtoBasicIdNameDescription.toSportSpecialization(pSport));
        return new MessagePOJO("OK");
    }
    
}
