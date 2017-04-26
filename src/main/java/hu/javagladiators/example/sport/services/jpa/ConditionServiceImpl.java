package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.services.GenericDaoServiceImpl;
import hu.javagladiators.example.sport.services.api.ConditionService;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author krisztian
 */
@RequestScoped
public class ConditionServiceImpl implements ConditionService{
    @Inject
    GenericDaoServiceImpl dao;
    

    @Override
    public Condition getConditionById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (Condition)dao.getEntity("Condition.findById", params);
    }

    @Override
     public List<Condition> getConditionByType(ConditionType pType) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("type", pType);
        return (List<Condition>)dao.getEntities("Condition.findByType", params);
    }

    @Override
    public void save(Condition pEntity) {
        dao.save(pEntity);
    }

    @Override
    public List<Condition> getConditionByType(ConditionType pType, Sport pSport) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("type", pType);
        params.put("sport", pSport);
        return (List<Condition>)dao.getEntities("Condition.findByTypeSport", params);
    }
    
    @Override
    public List<ConditionType> getAllConditionType() {
        return (List<ConditionType>)dao.getEntities("ConditionType.findAll", new HashMap<String, Object>());
    }

    @Override
    public ConditionType getConditionTypeById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (ConditionType)dao.getEntity("ConditionType.findById", params);
    }

    @Override
    public ConditionType getConditionTypeByName(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("name", pName);
        return (ConditionType)dao.getEntity("ConditionType.findByName", params);
    }

    @Override
    public void save(ConditionType pSeason) {
        dao.save(pSeason);
    }
}
