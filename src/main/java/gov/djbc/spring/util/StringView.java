/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 *
 * @author User
 */
@Component
public class StringView {

    @Inject
    HttpServletRequest request;
    private StringWriter html = new StringWriter();
    @Inject
    private VelocityViewResolver resolver;
    @Inject()
    HttpServletResponseFactoryBean httpServletResponseFactoryBean;

    public String renderToString(Map<String, ?> model, String viewName) {
        HttpServletResponse rsp = null;
        html = new StringWriter();
        try {
            Object o = httpServletResponseFactoryBean.getObject();
            rsp = (HttpServletResponse) o;
        } catch (Exception ex) {
            Logger.getLogger(StringView.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(rsp) {

            @Override
            public PrintWriter getWriter() throws IOException {
                return new PrintWriter(html);
            }
        };
        View vw;
        try {
            vw = resolver.resolveViewName(viewName, Locale.US);
            vw.render(model, request, wrapper);
            return html.toString();
        } catch (Exception ex) {
            Logger.getLogger(StringView.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    public String renderToString(String viewName) {
        Map<String, ?> model = new HashMap<String, Object>();
        return renderToString(model, viewName);
    }
}
