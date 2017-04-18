package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Season;
import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.javagladiators.example.sport.services.api.ConditionTypeService;
import hu.javagladiators.example.sport.services.api.SeasonService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * @author krisztian
 */
@Singleton
public class ConditionTypeServiceImpl implements ConditionTypeService{
    @Inject
    GenericDaoService dao;
    
    @Override
    public List<ConditionType> getAll() {
        return (List<ConditionType>)dao.getEntities("ConditionType.findAll", new HashMap<String, Object>());
    }

    @Override
    public ConditionType getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (ConditionType)dao.getEntity("ConditionType.findById", params);
    }

    @Override
    public ConditionType getByName(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("name", pName);
        return (ConditionType)dao.getEntity("ConditionType.findByName", params);
    }

    @Override
    public void save(ConditionType pSeason) {
        dao.save(pSeason);
    }
    
}
