package hu.javagladiators.framework.services.api;

import hu.javagladiators.framework.datamodel.Role;
import java.util.List;

/**
 * @author krisztian
 */
public interface CacheRoleService {
    public List<Role> getRolesByUserName(String pName);
    public void removeUserRolesFromCache(String pName);
    public void addUserRoleToCache(String pName,Role pRole);
}
