/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.framework.services;

import hu.javagladiators.framework.datamodel.Role;
import hu.javagladiators.framework.services.api.CacheRoleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Singleton
@Startup
public class CacheServiceImpl implements CacheRoleService{
    Logger log = LoggerFactory.getLogger(CacheServiceImpl.class.getSimpleName());
    private Map<String,List<Role>> userRoleCache = new HashMap<>();

    public CacheServiceImpl() {
        log.debug("CREATE INSTANCE");
    }
    
    
    
    @Override
    public List<Role> getRolesByUserName(String pName) {
        List<Role> res = new ArrayList<>();
        if(userRoleCache.get(pName) != null){
            res = userRoleCache.get(pName); 
        }
        return res;
    }

    @Override
    public void removeUserRolesFromCache(String pName) {
        userRoleCache.remove(pName);
        log.debug("REMOVE from userrole cache:"+pName);
    }

    @Override
    public void addUserRoleToCache(String pName, Role pRole) {
        if(userRoleCache.get(pName) == null){
            userRoleCache.put(pName, new ArrayList<Role>());
        }
        userRoleCache.get(pName).add(pRole);
        log.debug("ADD to userrole cache:"+pName);
    }
    
}
