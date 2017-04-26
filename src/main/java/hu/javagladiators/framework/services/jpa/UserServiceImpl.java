package hu.javagladiators.framework.services.jpa;

import hu.javagladiators.example.sport.services.GenericDaoServiceImpl;
import hu.javagladiators.framework.datamodel.Users;
import hu.javagladiators.framework.services.api.UserService;
import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author krisztian
 */
@RequestScoped
public class UserServiceImpl implements UserService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public Users getById(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("username", pName);
        return (Users)dao.getEntity("Users.findByUsername", params);
    }
}
