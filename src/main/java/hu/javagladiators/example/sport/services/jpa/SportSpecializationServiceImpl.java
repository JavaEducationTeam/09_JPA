package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.javagladiators.example.sport.services.api.SportSpecializationService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author krisztian
 */
@Singleton
@Startup
public class SportSpecializationServiceImpl implements SportSpecializationService {
    @Inject
    GenericDaoService dao;

    public SportSpecializationServiceImpl() {
    }
    
    
    @Override
    public List<SportSpecialization> getAllForSport(Sport pSport){
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
    public SportSpecialization getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pID);
        return (SportSpecialization)dao.getEntity("SportSpecialization.findById", params);    }
}
