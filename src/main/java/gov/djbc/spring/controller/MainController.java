/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.controller;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.StringPath;
import gov.djbc.spring.entity.Barang;
import gov.djbc.spring.entity.BarangDiInventory;
import gov.djbc.spring.entity.QBarang;
import gov.djbc.spring.fakentity.Referensi;
import gov.djbc.spring.filter.Fentry;
import gov.djbc.spring.filter.FilterUtil;
import gov.djbc.spring.repository.BarangDiInventoryRepository;
import gov.djbc.spring.repository.BarangRepository;

import java.math.BigDecimal;
import java.util.*;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class MainController {

    @Autowired
    private BarangRepository repo;
    @Inject
    private BarangDiInventoryRepository bdiRepo;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        Map m = new HashMap();
        m.put("dj", "http://192.168.204.12:8080/dojocdn171/dojolib");
//        m.put("dj", "http://localhost:8080/dojocdn171/dojolib");
        m.put("djext", ".js");
        ModelAndView mav = new ModelAndView("sprintory", m);
        return mav;
    }

    @RequestMapping(value = "/tes/{nama}")
    public @ResponseBody
    Map<String, Object> home(@PathVariable() String nama) {
        Map<String, Object> jsonOut = new HashMap<String, Object>();
        jsonOut.put("nama", nama + " (form path variable)");
        return jsonOut;
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/pabean")
    public String pabean() {
        return "pabean";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/tesvel")
    public ModelAndView tesVel() {
        // return "/WEB-INF/velocity/home.html";

        Map m = new HashMap();
        m.put("nama", "Tejo Tes Spring View");
        ModelAndView mav = new ModelAndView("home", m);
        return mav;
    }

    @RequestMapping(value = "/tesbarang/{nama}/{merk}")
    public @ResponseBody
    Iterable<BarangDiInventory> getBarang(@PathVariable String nama, @PathVariable String merk) {
        List<Fentry> fis = Arrays.asList(
                new Fentry[]{
                    FilterUtil.newItem("nama", nama, null, null, false, true, FilterUtil.FTYPE_TEXT)
                });
        Iterable<BarangDiInventory> hasil = bdiRepo.filter(fis);
        Barang bg = hasil.iterator().next().getBarang();
        System.out.println("hasilnya?" + hasil.toString());
//        return new FilterItem("alias", nama, new Date(), 5, true, true, merk);
        return hasil;
    }

    @RequestMapping(value = "/jsonmap")
    @SuppressWarnings({"rawtypes", "unchecked"})
    public @ResponseBody
    Map<String, Object> getMapReferensi(@RequestBody Referensi ref) {
        System.out.println("menerima referensi");
        System.out.println(ref.getNama());

        Referensi r = new Referensi();
        Referensi parent = new Referensi();
        r.setId(BigDecimal.ONE);
        r.setGrup("011");
        r.setNama("Piece");
        r.setKeterangan("Referensis");
        r.setKode("PCE");

        parent.setId(BigDecimal.ONE);
        parent.setGrup("01");
        parent.setNama("Piece");
        parent.setKeterangan("Piece");
        parent.setKode("PCE");

        r.setParent(parent);
        Map hasil = new HashMap<String, Object>();
        hasil.put("referensi", r);
        return hasil;
    }
}
