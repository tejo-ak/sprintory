/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
@RequestMapping(value = "/barang")
public class BarangController {

    @RequestMapping(value = "/browse/form")
    public String barangBrowse() {
        return "barang_browse";
    }
}
