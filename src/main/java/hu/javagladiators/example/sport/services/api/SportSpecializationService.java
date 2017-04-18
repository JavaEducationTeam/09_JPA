package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import hu.javagladiators.example.sport.datamodel.Sport;
import java.util.List;

/**
 * @author krisztian
 */
public interface SportSpecializationService {

    public SportSpecialization getById(Integer pID);

    public List<SportSpecialization> getAllForSport(Sport pSport);

    public void save(SportSpecialization pEntity);
}
