package hu.javagladiators.example.sport.datamodel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krisztian
 */
@Entity
@Table(name = "conditiontype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConditionType.findAll", query = "SELECT s FROM ConditionType s"),
    @NamedQuery(name = "ConditionType.findById", query = "SELECT s FROM ConditionType s WHERE s.id = :id"),
    @NamedQuery(name = "ConditionType.findByName", query = "SELECT s FROM ConditionType s WHERE s.name = :name")})
public class ConditionType extends BasicIdNameDescription implements Serializable {
    
}
