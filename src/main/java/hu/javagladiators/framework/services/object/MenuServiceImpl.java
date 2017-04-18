package hu.javagladiators.framework.services.object;

import hu.javagladiators.framework.datamodel.MenuItem;
import hu.javagladiators.framework.services.api.MenuService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@Singleton
@Startup
public class MenuServiceImpl implements MenuService{    
    private static final String ROLE_MANAGER = "manager";
    private static final String ROLE_TEAM = "team";
    private static final String ROLE_ATHLETE = "athlete";
    private static final String ROLE_USER = "user";
    
    private Logger log = LoggerFactory.getLogger(MenuServiceImpl.class.getSimpleName());

    public MenuServiceImpl() {
        log.debug("Create instance");
    }
    
    
       
    
    @Override
    public List<MenuItem> getByRoleName(String pRole) {
        List<MenuItem> res = new ArrayList<>();
        if(ROLE_MANAGER.equals(pRole)){
            res.add(new MenuItem("Sportág", "/html/admin/sport.jsp"));
            res.add(new MenuItem("Sportág specializáció", "/html/admin/sportSpecialization.jsp"));
            res.add(new MenuItem("Szezon", "/html/admin/season.jsp"));
            res.add(new MenuItem("Sorozat", "/html/admin/seria.jsp"));
            res.add(new MenuItem("Conditiontype", "/html/admin/conditiontype.jsp"));
            res.add(new MenuItem("Feltételek", "/html/admin/condition.jsp"));
            res.add(new MenuItem("Bajnokság", "/html/admin/championship.jsp"));
            res.add(new MenuItem("Bajnoki forduló", "/html/admin/round.jsp"));
        }
        if(ROLE_ATHLETE.equals(pRole)){
            res.add(new MenuItem("Jelentkezes", "/html/athlete/go.jsp"));
        }
        return res;
    }

    @Override
    public MenuItem getById(long pID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(MenuItem pEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
