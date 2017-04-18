package hu.javagladiators.example.sport.resources.admin;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.services.api.ConditionService;
import hu.javagladiators.example.sport.services.api.ConditionTypeService;
import hu.javagladiators.example.sport.services.api.SportService;
import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import hu.javagladiators.example.sport.viewmodel.system.MessagePOJO;
import hu.javagladiators.example.sport.viewmodel.NameDescriptionPOJO;
import hu.javagladiators.example.sport.viewmodel.BasicEntitiesDTO;
import hu.javagladiators.example.sport.viewmodel.condition.ConditionDTO;
import hu.javagladiators.example.sport.viewmodel.condition.ConditionPOJO;
import hu.javagladiators.example.sport.viewmodel.system.PagerPOJO;
import hu.javagladiators.example.sport.viewmodel.system.PickListPOJO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Path("/condition")
@Api(value = "Conditiond administration")
public class ConditionREST {
    Logger log = LoggerFactory.getLogger(ConditionREST.class.getSimpleName());
    
    @Inject
    ConditionService service;
    
    @Inject
    SportService serviceSport;
    
    @Inject
    ConditionTypeService serviceConditionType;

    @Inject
    BasicEntitiesDTO dtoBasicIdNameDescription;
    
    @Inject
    ConditionDTO dtoCondition;
    
    public ConditionREST() {
    }

    @GET
    @Path("/entity/page/{typeid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PagerPOJO entityList(
            @QueryParam("order")  @DefaultValue("asc") String order, 
            @QueryParam("offset") @DefaultValue("0")   long offset, 
            @QueryParam("limit")  @DefaultValue("10")  long limit,
           @ApiParam(value = "Szűrési típus, pl: éltkor, nem") @PathParam("typeid") int id
    ){
        PagerPOJO res = new PagerPOJO();
        ConditionType st = serviceConditionType.getById(id);
        res.setTotal(service.getByType(st).size());
        List data = new ArrayList();
        
       for(long i=offset;i<(offset+limit) && i<service.getByType(st).size();i++)
            data.add(service.getByType(st).get((int)i));
        res.setRows(data);
        return res;
    }
    
    @GET
    @Path("/entity/all/{typeid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Condition> entityList(
        @ApiParam(value = "Szűrési típus, pl: éltkor, nem") @PathParam("typeid") int id
    ){
        ConditionType st = serviceConditionType.getById(id);
        return service.getByType(st);
    }

    @GET
    @Path("/idname/all/{typeid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<IdNamePOJO> idnemeList(@PathParam("typeid") int id){
        ConditionType st = serviceConditionType.getById(id);
        List<IdNamePOJO> res = new ArrayList<>();
        List<Condition> entities = service.getByType(st);
        for(Condition entity : entities)
            res.add(IdNamePOJO.factoryDTO(entity));
        return res;
    }

    @GET
    @Path("namedescription/all/{typeid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<NameDescriptionPOJO> nemedescriptionList(@PathParam("typeid") int id){
        ConditionType st = serviceConditionType.getById(id);
        List<NameDescriptionPOJO> res = new ArrayList<>();
        List<Condition> entities = service.getByType(st);
        for(Condition entity : entities)
            res.add(dtoBasicIdNameDescription.factory(entity));
        return res;
    }
    
    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Condition findById(@PathParam("id") int id){
        return service.getById(id);
    }
    
    @GET
    @Path("/picklist/{sportid}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<PickListPOJO> getConditions(
           @ApiParam(value = "Sport azonosító", required = false) @PathParam("sportid") @DefaultValue("0") int pSportid
    ){
        List<PickListPOJO> res = new ArrayList<>();
        List<ConditionType> types = serviceConditionType.getAll();
        PickListPOJO tmp;
        List<Condition> coditions4Type;
        for(ConditionType type:types){
            tmp = new PickListPOJO();
            tmp.setTitle(type.getName());
            log.info(":::"+pSportid+":");
            if(pSportid >0)
                coditions4Type = service.getByType(type,serviceSport.getById(pSportid));
            else
                coditions4Type = service.getByType(type);
            for(Condition c:coditions4Type){
                tmp.addUnselected(IdNamePOJO.factoryDTO(c));
            }
            res.add(tmp);
        }
        return res;
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public MessagePOJO save(ConditionPOJO pModel){
        service.save(dtoCondition.factory(pModel,null));
        return new MessagePOJO("OK");
    }
    
}
