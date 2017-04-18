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
@Table(name = "season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Season.findAll", query = "SELECT s FROM Season s"),
    @NamedQuery(name = "Season.findById", query = "SELECT s FROM Season s WHERE s.id = :id"),
    @NamedQuery(name = "Season.findByName", query = "SELECT s FROM Season s WHERE s.name = :name")})
public class Season extends BasicIdNameDescription implements Serializable {
    
}
