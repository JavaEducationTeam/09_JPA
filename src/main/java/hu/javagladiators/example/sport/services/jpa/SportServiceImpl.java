package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import hu.javagladiators.example.sport.services.GenericDaoServiceImpl;
import hu.javagladiators.example.sport.services.api.SportService;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author krisztian
 */
@RequestScoped
public class SportServiceImpl implements SportService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public List<Sport> getAll() {
        return (List<Sport>)dao.getEntities("Sport.findAll", new HashMap<>());
    }

    @Override
    public Sport getSportById(Integer pID) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pID);
        return (Sport)dao.getEntity("Sport.findById", params);
    }

    @Override
    public Sport getSportByName(String pName) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("name", pName);
        return (Sport)dao.getEntity("Sport.findByName", params);
    }

    @Override
    public void save(Sport pSport) {
        dao.save(pSport);
    }
    
    @Override
    public List<SportSpecialization> getAllSportSpecializationForSport(Sport pSport){
        HashMap<String,Object> params = new HashMap<>();
        params.put("sport", pSport);
        return (List<SportSpecialization>)dao.getEntities("SportSpecialization.findBySport", params);
    }
    @Override
    public void save(SportSpecialization pEntity){
        dao.save(pEntity);
        pEntity.getSport().addSpecialization(pEntity);
        dao.save(pEntity.getSport());
    }

    @Override
    public SportSpecialization getSportSpecializationById(Integer pID) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pID);
        return (SportSpecialization)dao.getEntity("SportSpecialization.findById", params);    }
    
}
