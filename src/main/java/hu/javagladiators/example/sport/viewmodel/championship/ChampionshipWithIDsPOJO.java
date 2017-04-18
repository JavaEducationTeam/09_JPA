package hu.javagladiators.example.sport.viewmodel.championship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author krisztian
 */
public class ChampionshipWithIDsPOJO {
    protected String name,description;
    protected String startDate,endDate;
    protected Integer seasonid,seriaid;
    protected List<Integer> conditionid = new ArrayList<>();

    public ChampionshipWithIDsPOJO() {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public Integer getSeasonid() {
        return seasonid;
    }

    public void setSeasonid(Integer seasonid) {
        this.seasonid = seasonid;
    }

    public Integer getSeriaid() {
        return seriaid;
    }

    public void setSeriaid(Integer seriaid) {
        this.seriaid = seriaid;
    }

    public List<Integer> getConditionid() {
        return conditionid;
    }

    public void setConditionid(List<Integer> conditionid) {
        this.conditionid = conditionid;
    }
    
    
}
