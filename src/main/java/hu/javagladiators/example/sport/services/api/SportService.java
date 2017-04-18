package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Sport;
import java.util.List;

/**
 * @author krisztian
 */
public interface SportService {
    public List<Sport> getAll();
    public Sport getById(Integer pID);
    public Sport getByName(String pName);
    public void save(Sport pSport);
    
}
