/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.controller;

import gov.djbc.spring.fakentity.Referensi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
public class HomeController {
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("ini dilewati apa nggak ya ?");
		return "index";
	}

	@RequestMapping(value = "/tes/{nama}")
	public @ResponseBody
	Map<String, Object> home(@PathVariable() String nama) {
		Map<String, Object> jsonOut = new HashMap<String, Object>();
		jsonOut.put("nama", nama + " (form path variable)");
		return jsonOut;
	}

	@RequestMapping(value = "/tesHome")
	public String tesHome() {
		return "home";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/tesvel")
	public ModelAndView tesVel() {
		// return "/WEB-INF/velocity/home.html";
		Map m = new HashMap();
		m.put("nama", "Tejo Tes Spring View");
		ModelAndView mav = new ModelAndView("home", m);
		return mav;
	}

	@RequestMapping(value = "/json")
	public @ResponseBody
	Referensi getReferensi() {
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
		return r;
	}

	@RequestMapping(value = "/jsonmap")
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
