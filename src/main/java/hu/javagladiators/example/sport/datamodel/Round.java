
package hu.javagladiators.example.sport.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "round")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Round.findAll", query = "SELECT s FROM Round s"),
    @NamedQuery(name = "Round.findById", query = "SELECT s FROM Round s WHERE s.id = :id"),
    @NamedQuery(name = "Round.findByName", query = "SELECT s FROM Round s WHERE s.name = :name")})
public class Round extends BasicIdNameDescription implements Serializable {
 
    @OneToMany(fetch = FetchType.EAGER)
    private List<Race> race = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private SportEvent event;
    
    public List<Race> getRace() {
        return race;
    }

    public void setRace(List<Race> race) {
        this.race = race;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }


    
}
