package hu.javagladiators.example.sport.services.jpa;

import hu.javagladiators.example.sport.datamodel.Seria;
import hu.javagladiators.example.sport.services.GenericDaoServiceImpl;
import hu.javagladiators.example.sport.services.api.SeriaService;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author krisztian
 */
@RequestScoped
public class SeriaServiceImpl implements SeriaService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public List<Seria> getAll() {
        return (List<Seria>)dao.getEntities("Seria.findAll", new HashMap<String, Object>());
    }

    @Override
    public Seria getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", pID);
        return (Seria)dao.getEntity("Seria.findById", params);
    }

    @Override
    public Seria getByName(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("name", pName);
        return (Seria)dao.getEntity("Seria.findByName", params);
    }

    @Override
    public void save(Seria pSeria) {
        dao.save(pSeria);
    }
    
}
