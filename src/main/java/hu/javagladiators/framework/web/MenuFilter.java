/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.framework.web;

import hu.javagladiators.framework.cache.RoleCache;
import hu.javagladiators.framework.datamodel.MenuItem;
import hu.javagladiators.framework.datamodel.Role;
import hu.javagladiators.framework.services.api.CacheRoleService;
import hu.javagladiators.framework.services.api.MenuService;
import hu.javagladiators.framework.services.api.RoleService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author krisztian
 */
@WebFilter(filterName = "MenuFilter", urlPatterns = {"/html/*"})
public class MenuFilter implements Filter {
    Logger log = LoggerFactory.getLogger(MenuFilter.class.getSimpleName());

    @Inject
    RoleService serviceRole;
    
    @Inject
    MenuService serviceMenu;

    @Inject
    CacheRoleService serviceCacheUserRoles;
    
    public MenuFilter() {
        log.debug("Create instance");
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        log.info("FILTER:" + MenuFilter.class.getName());
        HttpServletRequest req = (HttpServletRequest)request;
        String userName = req.getUserPrincipal().getName();

//user roles
        List<Role> roles = serviceCacheUserRoles.getRolesByUserName(userName);
        if(roles == null || roles.size() == 0){
            List<Role> allRoles = serviceRole.getAllRoles();
            for(Role role:allRoles){
                log.info(userName+":"+role.getRole()+"="+req.isUserInRole(role.getRole()));
                if(req.isUserInRole(role.getRole())){
                    serviceCacheUserRoles.addUserRoleToCache(userName, role);
                }
            }
            roles = serviceCacheUserRoles.getRolesByUserName(userName);
        }

//menu items;        
        List<MenuItem> menuItems = new ArrayList<>();
        for(Role role : roles){
            menuItems.addAll(serviceMenu.getByRoleName(userName));
        }
        
//User Interface
        request.setAttribute("menuitems", menuItems);
        request.getServletContext().getRequestDispatcher("/html/header.jsp").include(request, response);
        chain.doFilter(request, response);
        request.getServletContext().getRequestDispatcher("/html/footer.jsp").include(request, response);

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
    }

}
