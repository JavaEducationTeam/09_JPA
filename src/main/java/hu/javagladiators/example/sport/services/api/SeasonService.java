package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Season;
import java.util.List;

/**
 * @author krisztian
 */
public interface SeasonService {
    public List<Season> getAll();
    public Season getById(Integer pID);
    public Season getByName(String pName);
    public void save(Season pSeason);
    
}
