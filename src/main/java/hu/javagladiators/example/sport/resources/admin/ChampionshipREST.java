package hu.javagladiators.example.sport.resources.admin;



import com.jcabi.aspects.Loggable;
import hu.javagladiators.example.sport.datamodel.Championship;
import hu.javagladiators.example.sport.datamodel.Round;
import hu.javagladiators.example.sport.datamodel.SportEvent;
import hu.javagladiators.example.sport.services.api.ChampionshipService;
import hu.javagladiators.example.sport.services.api.ConditionService;
import hu.javagladiators.example.sport.services.api.SeasonService;
import hu.javagladiators.example.sport.services.api.SeriaService;
import hu.javagladiators.example.sport.services.api.SportService;
import hu.javagladiators.example.sport.viewmodel.championship.ChampionshipWithIDsPOJO;
import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import hu.javagladiators.example.sport.viewmodel.system.MessagePOJO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionPOJO;
import hu.javagladiators.example.sport.viewmodel.BasicEntitiesDTO;
import hu.javagladiators.example.sport.viewmodel.championship.ChampionshipDTO;
import hu.javagladiators.example.sport.viewmodel.championship.ChampionshipSportSpecializationIDPOJO;
import hu.javagladiators.example.sport.viewmodel.championship.RoundPOJO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Path("/championship")
@Api(value = "Championships administration")
public class ChampionshipREST {
    private static final Logger log = LoggerFactory.getLogger(ChampionshipREST.class.getSimpleName());

    @Inject
    ChampionshipService service;
    
    @Inject
    SportService serviceSport;
    
    @Inject
    SeriaService serviceSeria;
    
    @Inject 
    SeasonService serviceSeason;
    
    @Inject
    ConditionService serviceCondition;
            
    @Inject
    ChampionshipDTO dtoChampionship ;//= new ChampionshipDTO(serviceSport, serviceSeria, serviceSeason, serviceCondition);

    @Inject
    BasicEntitiesDTO dtoBasicIdNameDescription;
    
    
    public ChampionshipREST() {
        log.info("CREATE Instance");
    }

    
    @GET
    @Path("/entity/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO, prepend = true)
    public List<Championship> entityList(){
        return service.getAll();
    }

    @GET
    @Path("/idname/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public List<IdNamePOJO> idnemeList(){
        List<IdNamePOJO> res = new ArrayList<>();
        List<Championship> entities = service.getAll();
        for(Championship entity : entities)
            res.add(IdNamePOJO.factoryDTO(entity));
        return res;
    }

    @GET
    @Path("namedescription/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public List<NameDescriptionPOJO> nemedescriptionList(){
        List<NameDescriptionPOJO> res = new ArrayList<>();
        List<Championship> entities = service.getAll();
        for(Championship entity : entities)
            res.add(dtoBasicIdNameDescription.factory(entity));
        return res;
    }
    
    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public Championship findById(@PathParam("id") int id){
        return service.getById(id);
    }
    
    
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public MessagePOJO save(ChampionshipWithIDsPOJO pData){
        service.save(dtoChampionship.toChampionship(pData, null));
        return new MessagePOJO("OK");
    }

    @GET
    @Path("/events/idname/{championshipid}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public List<IdNamePOJO> getEventByChampionship(
            @ApiParam(value = "Championshipid") @PathParam("championshipid") @DefaultValue("0") int pID
    ){
        List<IdNamePOJO> res = new ArrayList<>();
        Set<SportEvent> events = service.getById(pID).getEvent();
        IdNamePOJO tmp;
        for(SportEvent event : events){
            tmp = new IdNamePOJO();
            tmp.setId(new Integer((int)event.getId()));
            if(event.getSpecialization() != null)
                tmp.setName(event.getSport().getName()+"("+event.getSpecialization().getName()+")");
            else
                tmp.setName(event.getSport().getName());;
            res.add(tmp);
        }
        return res;
    }
    
    @POST
    @Path("/addsport")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public MessagePOJO addSport(ChampionshipSportSpecializationIDPOJO pData){
        Championship championship = service.getById(pData.getChampionshipid());
        Set<SportEvent> events = dtoChampionship.toSportEvents(pData);
        for(SportEvent event:events){
            championship.addEvent(event);
        }
        service.save(championship);
        return new MessagePOJO("OK");
    }
    
    
    
    
    @POST
    @Path("/addround")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public MessagePOJO addRound(RoundPOJO pData){
        SportEvent event = service.getEventById(pData.getEventid());
        Round round = dtoChampionship.toRound(pData);
        round.setEvent(event);
        event.addRound(round);
        service.save(event);
        return new MessagePOJO("OK");
    }
}

 