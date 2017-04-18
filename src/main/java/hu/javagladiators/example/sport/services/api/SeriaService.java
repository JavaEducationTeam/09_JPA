package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Seria;
import java.util.List;

/**
 * @author krisztian
 */
public interface SeriaService {
    public List<Seria> getAll();
    public Seria getById(Integer pID);
    public Seria getByName(String pName);
    public void save(Seria pSeria);
    
}
