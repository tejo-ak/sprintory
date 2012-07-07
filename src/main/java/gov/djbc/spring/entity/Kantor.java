/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Kantor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 6)
    private String kode;
    @Column(length = 64)
    private String nama;
    //=====================
    //list of referensi kantor
    //=====================
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "kantor")
    private List<DokumenPabean> dokumenByKantor;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "kantorBongkar")
    private List<DokumenPabean> dokumenByKantorBongkar;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "kantorAwas")
    private List<DokumenPabean> dokumenByKantorAwas;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "kantorPeriksa")
    private List<DokumenPabean> dokumenByKantorPeriksa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<DokumenPabean> getDokumenByKantor() {
        return dokumenByKantor;
    }

    public void setDokumenByKantor(List<DokumenPabean> dokumenByKantor) {
        this.dokumenByKantor = dokumenByKantor;
    }

    public List<DokumenPabean> getDokumenByKantorAwas() {
        return dokumenByKantorAwas;
    }

    public void setDokumenByKantorAwas(List<DokumenPabean> dokumenByKantorAwas) {
        this.dokumenByKantorAwas = dokumenByKantorAwas;
    }

    public List<DokumenPabean> getDokumenByKantorBongkar() {
        return dokumenByKantorBongkar;
    }

    public void setDokumenByKantorBongkar(List<DokumenPabean> dokumenByKantorBongkar) {
        this.dokumenByKantorBongkar = dokumenByKantorBongkar;
    }

    public List<DokumenPabean> getDokumenByKantorPeriksa() {
        return dokumenByKantorPeriksa;
    }

    public void setDokumenByKantorPeriksa(List<DokumenPabean> dokumenByKantorPeriksa) {
        this.dokumenByKantorPeriksa = dokumenByKantorPeriksa;
    }
}
