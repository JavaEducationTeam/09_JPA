package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Sport;
import java.util.List;

/**
 * @author krisztian
 */
public interface ConditionService {
    public Condition getConditionById(Integer pID);
    public List<Condition> getConditionByType(ConditionType pType);
    public List<Condition> getConditionByType(ConditionType pType, Sport pSport);
    public void save(Condition pEntity);
 
    public List<ConditionType> getAllConditionType();
    public ConditionType getConditionTypeById(Integer pID);
    public ConditionType getConditionTypeByName(String pName);
    public void save(ConditionType pEntity);
}
