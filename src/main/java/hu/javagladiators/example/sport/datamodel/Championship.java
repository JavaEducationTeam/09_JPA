package hu.javagladiators.example.sport.datamodel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author krisztian
 */
@Entity
@Table(name = "championship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championship.findAll", query = "SELECT c FROM Championship c"),
    @NamedQuery(name = "Championship.findById", query = "SELECT c FROM Championship c WHERE c.id = :id"),
    @NamedQuery(name = "Championship.findByName", query = "SELECT c FROM Championship c WHERE c.name = :name")})
public class Championship extends BasicIdNameDescription implements Serializable {
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SERIES_ID")
    @Basic(optional = false)
    Seria seria;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SEASON_ID")
    @Basic(optional = false)
    Season season;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "championship",orphanRemoval = true, cascade = CascadeType.ALL)
    Set<SportEvent> event = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    Set<Condition> condition = new HashSet<>();
    
    //@Temporal(TemporalType.DATE)    
    String startDate;
    
    //@Temporal(TemporalType.DATE)    
    String endDate;
    
            
    public Championship() {
    }

    public Championship(Integer id) {
        this.id = id;
    }

    public Championship(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Seria getSeria() {
        return seria;
    }

    public void setSeria(Seria seria) {
        this.seria = seria;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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

    public Set<Condition> getCondition() {
        return condition;
    }

    public void setCondition(Set<Condition> condition) {
        this.condition = condition;
    }
    
    public void addCondition(Condition condition) {
        this.condition.add(condition);
    }    

    public Set<SportEvent> getEvent() {
        return event;
    }

    public void setEvent(Set<SportEvent> event) {
        this.event = event;
    }

    public void addEvent(SportEvent event) {
        event.setChampionship(this);
        if(this.event==null) 
            this.event = new HashSet<>();
        this.event.add(event);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championship)) {
            return false;
        }
        Championship other = (Championship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.example.sport.datamodel.Champion[ id=" + id + " ]";
    }
    
}
