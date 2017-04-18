package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Season;
import java.util.List;

/**
 * @author krisztian
 */
public interface ConditionTypeService {
    public List<ConditionType> getAll();
    public ConditionType getById(Integer pID);
    public ConditionType getByName(String pName);
    public void save(ConditionType pEntity);
    
}
