/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.controller;

import gov.djbc.spring.filter.Fentry;
import gov.djbc.spring.filter.Paging;
import gov.djbc.spring.repository.BarangRepository;
import gov.djbc.spring.util.StringView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
@RequestMapping(value = "/barang")
public class BarangController {

    @Inject
    private Map<String, Object> jout;
    @Inject
    private BarangRepository repo;
    @Inject
    private StringView sv;

    @RequestMapping(value = "/browse/form")
    public @ResponseBody
    Map barangBrowse(HttpServletResponse response) {
        Map<String, Object> p = new HashMap<String, Object>();

        p.put("html", sv.renderToString("barang_browse"));
        p.put("sukses", true);
        return p;
    }

    @RequestMapping(value = "/browse/fetch")
    public @ResponseBody
    Map fetchBarang(@RequestBody Paging paging, @RequestBody List<Fentry> fentries, @RequestBody boolean init) {
        System.out.println("paging " + paging);
        jout.put("data", repo.findAll());
        return jout;
    }
}
