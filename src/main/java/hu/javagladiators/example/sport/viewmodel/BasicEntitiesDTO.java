package hu.javagladiators.example.sport.viewmodel;

import hu.javagladiators.example.sport.datamodel.BasicIdNameDescription;
import hu.javagladiators.example.sport.datamodel.ConditionType;
import hu.javagladiators.example.sport.datamodel.Season;
import hu.javagladiators.example.sport.datamodel.Seria;
import hu.javagladiators.example.sport.datamodel.Sport;
import hu.javagladiators.example.sport.datamodel.SportSpecialization;
import hu.javagladiators.example.sport.services.api.SportService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


/**
 * @author krisztian
 */
@ApplicationScoped
public class BasicEntitiesDTO {
    
    @Inject
    private SportService serviceSport;

    
    public NameDescriptionPOJO factory(BasicIdNameDescription pValue){
         return new NameDescriptionPOJO(pValue.getName(), pValue.getDescription());
    }
    
    public Sport toSport(NameDescriptionPOJO pData){
        Sport res = new Sport();
        res.setName(pData.getName());
        res.setDescription(pData.getDescription());
        return res;
    }
    
    public SportSpecialization toSportSpecialization(NameDescriptionParendIDPOJO pData){
        SportSpecialization res = new SportSpecialization();
        res.setName(pData.getName());
        res.setDescription(pData.getDescription());
        res.setSport(serviceSport.getSportById(pData.getParendid()));
        return res;
    }
    
    public Season toSeason(NameDescriptionPOJO pData){
        Season res = new Season();
        res.setName(pData.getName());
        res.setDescription(pData.getDescription());
        return res;
    }
    
    public Seria toSeria(NameDescriptionPOJO pData){
        Seria res = new Seria();
        res.setName(pData.getName());
        res.setDescription(pData.getDescription());
        return res;
    }

    public ConditionType toConditionType(NameDescriptionPOJO pData){
        ConditionType res = new ConditionType();
        res.setName(pData.getName());
        res.setDescription(pData.getDescription());
        return res;
    }
}
