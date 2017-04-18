package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.javagladiators.example.sport.services.api.SportService;
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
public class SportServiceImpl implements SportService{
    @Inject
    GenericDaoService dao;
    
    @Override
    public List<Sport> getAll() {
        return (List<Sport>)dao.getEntities("Sport.findAll", new HashMap<>());
    }

    @Override
    public Sport getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pID);
        return (Sport)dao.getEntity("Sport.findById", params);
    }

    @Override
    public Sport getByName(String pName) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("name", pName);
        return (Sport)dao.getEntity("Sport.findByName", params);
    }

    @Override
    public void save(Sport pSport) {
        dao.save(pSport);
    }
    
}
