/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
public class StringViewUtil extends HttpServletResponseWrapper {

    StringWriter html = new StringWriter();
    HttpServletResponse response;
    String name;

    public StringViewUtil(HttpServletResponse response, String name) {
        super(response);
        this.response = response;
        this.name = name;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(html);
    }

    public StringWriter getStringWriter() {
        return html;
    }

    public String RenderToString() {
        try {
            ModelAndView mav = new ModelAndView(name);
            StringViewUtil sv = new StringViewUtil(this.response, this.name);
            mav.getView().render(mav.getModel(), null, sv);
            html = sv.getStringWriter();
            return html.toString();
        } catch (Exception ex) {
//            Logger.getLogger(StringView.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
