package hu.javagladiators.example.sport.viewmodel.championship;

import java.util.List;

/**
 * @author krisztian
 */
public class ChampionshipSportSpecializationIDPOJO {
    private Integer championshipid,sportid;
    private List<Integer> specializationid;
    private List<Integer> conditionid;

    public ChampionshipSportSpecializationIDPOJO() {
    }

    public Integer getChampionshipid() {
        return championshipid;
    }

    public void setChampionshipid(Integer championshipid) {
        this.championshipid = championshipid;
    }

    public Integer getSportid() {
        return sportid;
    }

    public void setSportid(Integer sportid) {
        this.sportid = sportid;
    }

    public List<Integer> getSpecializationid() {
        return specializationid;
    }

    public void setSpecializationid(List<Integer> specialization) {
        this.specializationid = specialization;
    }

    public List<Integer> getConditionid() {
        return conditionid;
    }

    public void setConditionid(List<Integer> condition) {
        this.conditionid = condition;
    }
    
    
    
}
