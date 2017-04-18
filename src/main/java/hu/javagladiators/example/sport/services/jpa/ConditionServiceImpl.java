package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.javagladiators.example.sport.services.api.ConditionService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * @author krisztian
 */
@Singleton
public class ConditionServiceImpl implements ConditionService{
    @Inject
    GenericDaoService dao;
    

    @Override
    public Condition getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (Condition)dao.getEntity("Condition.findById", params);
    }

    @Override
     public List<Condition> getByType(ConditionType pType) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("type", pType);
        return (List<Condition>)dao.getEntities("Condition.findByType", params);
    }

    @Override
    public void save(Condition pEntity) {
        dao.save(pEntity);
    }

    @Override
    public List<Condition> getByType(ConditionType pType, Sport pSport) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("type", pType);
        params.put("sport", pSport);
        return (List<Condition>)dao.getEntities("Condition.findByTypeSport", params);
    }
    
}
