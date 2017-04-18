package hu.javagladiators.example.sport.viewmodel;

import hu.javagladiators.example.sport.datamodel.BasicIdNameDescription;
import hu.javagladiators.example.sport.datamodel.Sport;

/**
 * @author krisztian
 */
public class IdNamePOJO {
    protected Integer id;
    protected String name;
 
    public IdNamePOJO() {
    }

    public static IdNamePOJO factoryDTO(BasicIdNameDescription pValue){
        return new IdNamePOJO(pValue.getId(),pValue.getName());
    }
    
    public IdNamePOJO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
