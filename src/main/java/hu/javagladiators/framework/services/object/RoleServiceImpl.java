package hu.javagladiators.framework.services.object;

import hu.javagladiators.framework.datamodel.Role;
import hu.javagladiators.framework.services.api.RoleService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author krisztian
 */
@Singleton
@Startup
public class RoleServiceImpl implements RoleService{
    private static final String ROLE_MANAGER = "manager";
    private static final String ROLE_TEAM = "team";
    private static final String ROLE_ATHLETE = "athlete";
    private static final String ROLE_USER = "user";

    public List<Role> getAllRoles(){
        List<Role> res = new ArrayList<>();
        res.add(new Role(ROLE_MANAGER));
        res.add(new Role(ROLE_TEAM));
        res.add(new Role(ROLE_ATHLETE));
        res.add(new Role(ROLE_USER));
        return res;
    }

    @Override
    public void save(Role pEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
