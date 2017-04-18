package hu.javagladiators.example.sport.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.javagladiators.framework.datamodel.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krisztian
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportEvent.findAll", query = "SELECT c FROM SportEvent c"),
    @NamedQuery(name = "SportEvent.findById", query = "SELECT c FROM SportEvent c WHERE c.id = :id")})
public class SportEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sport_id")
    private Sport sport;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialization_id")
    private SportSpecialization specialization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "championship_id")
    @JsonIgnore
    private Championship championship;
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    Set<Condition> condition = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event", orphanRemoval = true, cascade = CascadeType.ALL)
    Set<Round> round = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="event_user",
            joinColumns = @JoinColumn( name="event_id"),
            inverseJoinColumns = @JoinColumn( name="user_id")
        )
    Set<Users> user = new HashSet<>();
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Users> getUser() {
        return user;
    }

    public void setUser(Set<Users> user) {
        this.user = user;
    }
    
    public void addUser(Users user) {
        this.user.add(user);
    }
    
        

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public SportSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SportSpecialization specialization) {
        this.specialization = specialization;
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

    public Set<Round> getRound() {
        return round;
    }

    public void setRound(Set<Round> round) {
        this.round = round;
    }
    
    public void addRound(Round round) {
//        round.setEvent(this);
        this.round.add(round);
    }
  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SportEvent)) {
            return false;
        }
        SportEvent other = (SportEvent) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.example.sport.datamodel.sportevent[ id=" + id + " ]";
    }
    
}
