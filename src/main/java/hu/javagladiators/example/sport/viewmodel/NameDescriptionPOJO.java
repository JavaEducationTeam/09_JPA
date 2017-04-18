package hu.javagladiators.example.sport.viewmodel;

import hu.javagladiators.example.sport.datamodel.BasicIdNameDescription;
import hu.javagladiators.example.sport.datamodel.Sport;

/**
 * @author krisztian
 */
public class NameDescriptionPOJO {
    protected String name,description;

    public NameDescriptionPOJO() {
    }

    public NameDescriptionPOJO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
