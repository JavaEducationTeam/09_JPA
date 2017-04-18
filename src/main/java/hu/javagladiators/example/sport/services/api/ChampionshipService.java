package hu.javagladiators.example.sport.services.api;

import hu.javagladiators.example.sport.datamodel.Championship;
import hu.javagladiators.example.sport.datamodel.Season;
import hu.javagladiators.example.sport.datamodel.Seria;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.datamodel.SportEvent;
import java.util.List;

/**
 * @author krisztian
 */
public interface ChampionshipService {
    public List<Championship> getAll();
    public Championship getById(Integer pID);
    public List<Championship> getByData(Sport pSport, Seria pSeria, Season pSeasonID);
    public void save(Championship pEntity);
    public void save(SportEvent pEntity);
    public SportEvent getEventById(long pId);
}
