package hu.javagladiators.example.sport.resources;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("rest")
public class RESTApplication extends Application{

    public RESTApplication() {
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080/sport");
        beanConfig.setBasePath("/rest");
        beanConfig.setResourcePackage("hu.javagladiators.example.sport.resources");      
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
        
    }
    
   
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(hu.javagladiators.example.sport.resources.admin.SportSpecializationREST.class);
        resources.add(hu.javagladiators.example.sport.resources.athlete.EventEntryREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.ConditionTypeREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.ConditionREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.ChampionshipREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.SportREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.SeasonREST.class);
        resources.add(hu.javagladiators.example.sport.resources.admin.SeriaREST.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        resources.add(org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature.class);
        return resources;
    }
    
}
