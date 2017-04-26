package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import java.util.List;

/**
 * @author krisztian
 */
public interface SportService {
    public List<Sport> getAll();
    public Sport getSportById(Integer pID);
    public Sport getSportByName(String pName);
    public void save(Sport pSport);
    
   public SportSpecialization getSportSpecializationById(Integer pID);

    public List<SportSpecialization> getAllSportSpecializationForSport(Sport pSport);

    public void save(SportSpecialization pEntity);
}
