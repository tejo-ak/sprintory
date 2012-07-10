/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.util;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class HttpServletResponseFactoryBean implements FactoryBean {

    private ResponseInScopeFilter responseInScopeFilter;

    public void setResponseInScopeFilter(ResponseInScopeFilter responseInScopeFilter) {
        this.responseInScopeFilter = responseInScopeFilter;
    }

    public Object getObject() throws Exception {
        return responseInScopeFilter.getHttpServletResponse();
    }

    public Class getObjectType() {
        return HttpServletResponse.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
