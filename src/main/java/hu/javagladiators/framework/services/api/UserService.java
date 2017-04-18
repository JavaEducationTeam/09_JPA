/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.framework.services.api;

import hu.javagladiators.framework.datamodel.Users;

/**
 *
 * @author krisztian
 */
public interface UserService {
    
    public Users getById(String pName);
    
}
