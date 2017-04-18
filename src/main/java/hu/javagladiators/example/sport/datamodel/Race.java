/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "race")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Race.findAll", query = "SELECT s FROM Race s"),
    @NamedQuery(name = "Race.findById", query = "SELECT s FROM Race s WHERE s.id = :id"),
    @NamedQuery(name = "Race.findByName", query = "SELECT s FROM Race s WHERE s.name = :name")})
public class Race extends BasicIdNameDescription implements Serializable {
    
}