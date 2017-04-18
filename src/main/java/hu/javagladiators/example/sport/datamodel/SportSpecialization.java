/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.example.sport.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author krisztian
 */
@Entity
@Table(name = "specialization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportSpecialization.findAll", query = "SELECT s FROM SportSpecialization s"),
    @NamedQuery(name = "SportSpecialization.findById", query = "SELECT s FROM SportSpecialization s WHERE s.id = :id"),
    @NamedQuery(name = "SportSpecialization.findBySport", query = "SELECT s FROM SportSpecialization s WHERE s.sport = :sport")})
public class SportSpecialization extends BasicIdNameDescription implements Serializable {
    
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "sport_id")
    @Nullable
    @JsonIgnore
    private Sport sport;

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
    
}
