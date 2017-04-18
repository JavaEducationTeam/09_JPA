package hu.javagladiators.framework.services.jpa;

import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.javagladiators.framework.datamodel.Users;
import hu.javagladiators.framework.services.api.UserService;
import java.util.HashMap;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * @author krisztian
 */
@Singleton
public class UserServiceImpl implements UserService{
    @Inject
    GenericDaoService dao;
    
    @Override
    public Users getById(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("username", pName);
        return (Users)dao.getEntity("Users.findByUsername", params);
    }
}
