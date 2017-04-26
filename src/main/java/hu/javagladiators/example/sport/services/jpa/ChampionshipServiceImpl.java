package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Championship;
import hu.javagladiators.example.sport.datamodel.Season;
import hu.javagladiators.example.sport.datamodel.Seria;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.datamodel.SportEvent;
import hu.javagladiators.example.sport.services.GenericDaoServiceImpl;
import hu.javagladiators.example.sport.services.api.ChampionshipService;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author krisztian
 */
@RequestScoped
public class ChampionshipServiceImpl implements ChampionshipService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public List<Championship> getAll() {
        return (List<Championship>)dao.getEntities("Championship.findAll", new HashMap<String, Object>());
    }

    @Override
    public Championship getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (Championship)dao.getEntity("Championship.findById", params);
   }

    @Override
    public List<Championship> getByData(Sport pSport, Seria pSeria, Season pSeason) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("sport", pSport);
        params.put("seria", pSeria);
        params.put("season", pSeason);
        return (List<Championship>)dao.getEntities("Championship.findByConnect", params);
    }

    @Override
    public void save(Championship pEntity) {
        dao.save(pEntity);
    }

    @Override
    public SportEvent getEventById(long pId) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pId);
        return (SportEvent)dao.getEntity("SportEvent.findById", params);
    }

    @Override
    public void save(SportEvent pEntity) {
       dao.save(pEntity);
    }
    
}
