/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.example.sport.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krisztian
 */
@Entity
@Table(name = "sport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s"),
    @NamedQuery(name = "Sport.findById", query = "SELECT s FROM Sport s WHERE s.id = :id"),
    @NamedQuery(name = "Sport.findByName", query = "SELECT s FROM Sport s WHERE s.name = :name")})
public class Sport extends BasicIdNameDescription implements Serializable {
    
    @OneToMany(mappedBy = "sport", fetch = FetchType.EAGER)
    @Nullable
    private List<SportSpecialization> specialization = new ArrayList<>();

    public List<SportSpecialization> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<SportSpecialization> specialization) {
        this.specialization = specialization;
    }
    
    public void addSpecialization(SportSpecialization specialization) {
        this.specialization.add(specialization);
    }
    
}
