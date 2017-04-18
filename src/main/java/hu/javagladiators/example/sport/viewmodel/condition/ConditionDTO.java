package hu.javagladiators.example.sport.viewmodel.condition;

import hu.javagladiators.example.sport.datamodel.Condition;
import hu.javagladiators.example.sport.services.api.ConditionTypeService;
import hu.javagladiators.example.sport.services.api.SportService;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author krisztian
 */
@Singleton
@Startup
public class ConditionDTO {
    @Inject
    private ConditionTypeService service;
    
    @Inject
    private SportService serviceSport;
            
    public ConditionDTO() {
    }
    
    public Condition factory(ConditionPOJO pModel, Condition pEntity){
        if(pEntity == null ) pEntity = new Condition();
        pEntity.setName(pModel.getName());
        if(pModel.getSportid()>0)
            pEntity.setSport(serviceSport.getById(pModel.getSportid()));
        pEntity.setDescription(pModel.getDescription());
        pEntity.setMinumum(pModel.getMinimum());
        pEntity.setMaximum(pModel.getMaximum());
        pEntity.setEqual(pModel.getEqual());
        pEntity.setType(service.getById(pModel.getTypeid()));
        return pEntity;
    }
    
    public ConditionTextPOJO toConditionTextPOJO(Condition pEntity){
        ConditionTextPOJO res = new ConditionTextPOJO();
        res.setDescription(pEntity.getDescription());
        res.setName(pEntity.getName());
        res.setType(pEntity.getType().getName());
        if(pEntity.getEqual() != null && !pEntity.getEqual().isEmpty())
            res.setText(pEntity.getEqual());
        else res.setText(pEntity.getMinumum()+" - "+pEntity.getMaximum());
        return res;
    }
    
    
}
