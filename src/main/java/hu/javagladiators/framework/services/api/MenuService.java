package hu.javagladiators.framework.services.api;

import hu.javagladiators.framework.datamodel.MenuItem;
import java.util.List;

/**
 * @author krisztian
 */
public interface MenuService {
    public List<MenuItem> getByRoleName(String pRole);
    public MenuItem getById(long pID);
    public void save(MenuItem pEntity);
    
}
