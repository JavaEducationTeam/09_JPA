
package hu.javagladiators.example.sport.datamodel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krisztian
 */
@Entity
@Table(name = "seria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seria.findAll", query = "SELECT s FROM Seria s"),
    @NamedQuery(name = "Seria.findById", query = "SELECT s FROM Seria s WHERE s.id = :id"),
    @NamedQuery(name = "Seria.findByName", query = "SELECT s FROM Seria s WHERE s.name = :name")})
public class Seria extends BasicIdNameDescription implements Serializable {
    
}