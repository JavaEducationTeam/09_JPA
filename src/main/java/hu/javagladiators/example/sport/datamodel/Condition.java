package hu.javagladiators.example.sport.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krisztian
 */
@Entity
@Table(name = "conditiont")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condition.findAll", query = "SELECT s FROM Condition s"),
    @NamedQuery(name = "Condition.findById", query = "SELECT s FROM Condition s WHERE s.id = :id"),
    @NamedQuery(name = "Condition.findByType", query = "SELECT s FROM Condition s WHERE s.type = :type"),
    @NamedQuery(name = "Condition.findByTypeSport", query = "SELECT s FROM Condition s WHERE s.type = :type AND s.sport = :sport")})
public class Condition extends BasicIdNameDescription implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conditiontype_id")
    ConditionType type;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sport_id")
    @Nullable
    @Basic(optional = true)
    private Sport sport;
    
    @Nullable
    private String minumum;
    @Nullable
    private String maximum;
    @Nullable
    private String equal;


    
    public ConditionType getType() {
        return type;
    }

    public void setType(ConditionType type) {
        this.type = type;
    }

    public String getMinumum() {
        return minumum;
    }

    public void setMinumum(String minumum) {
        this.minumum = minumum;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
    
    
}
