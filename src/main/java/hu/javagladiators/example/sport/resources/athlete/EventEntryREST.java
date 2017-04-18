package hu.javagladiators.example.sport.resources.athlete;

import hu.javagladiators.example.sport.datamodel.Championship;
import hu.javagladiators.example.sport.datamodel.SportEvent;
import hu.javagladiators.example.sport.services.api.ChampionshipService;
import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionPOJO;
import hu.javagladiators.example.sport.viewmodel.system.MessagePOJO;
import hu.javagladiators.framework.datamodel.Users;
import hu.javagladiators.framework.services.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
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
@Path("/entry")
@Api(value = "Jelentkezés")
@PermitAll
public class EventEntryREST {
    Logger log = LoggerFactory.getLogger(EventEntryREST.class.getSimpleName());
 
    @Inject
    ChampionshipService serviceChampionship;
    
    @Inject
    UserService serviceUser;
    
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
   // @RolesAllowed(value = {"athlete"})
    public MessagePOJO save(@Context SecurityContext sc,
            IdNamePOJO pData
    ){
        log.info(sc.getUserPrincipal().getName()+":"+sc.isUserInRole("athlet"));
        Users user = serviceUser.getById(sc.getUserPrincipal().getName());
        SportEvent event = serviceChampionship.getEventById(pData.getId()); 
        event.addUser(user);
        
        serviceChampionship.save(event);
        return new MessagePOJO("OK");
    }
    
}
