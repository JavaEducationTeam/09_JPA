package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Sport;
import java.util.List;

/**
 * @author krisztian
 */
public interface ConditionService {
    public Condition getById(Integer pID);
    public List<Condition> getByType(ConditionType pType);
    public List<Condition> getByType(ConditionType pType, Sport pSport);
    public void save(Condition pEntity);
    
}
