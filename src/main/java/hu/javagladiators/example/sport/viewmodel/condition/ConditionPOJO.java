package hu.javagladiators.example.sport.viewmodel.condition;

/**
 * @author krisztian
 */
public class ConditionPOJO {
    protected String minimum,maximum,equal,name,description;
    protected Integer typeid,sportid;

    public ConditionPOJO() {
    }

    
    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minumum) {
        this.minimum = minumum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getEqual() {
        return equal;
    }

    public void setEqual(String equal) {
        this.equal = equal;
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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getSportid() {
        return sportid;
    }

    public void setSportid(Integer sportid) {
        this.sportid = sportid;
    }

}
