package hu.javagladiators.framework.services.api;

import hu.javagladiators.framework.datamodel.Role;
import java.util.List;

/**
 * @author krisztian
 */
public interface RoleService {
    public List<Role> getAllRoles();
    public void save(Role pEntity);
}
