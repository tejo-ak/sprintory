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
public class Pelabuhan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 6)
    private String kode;
    @Column(length = 32)
    private String nama;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi negara;
    //=====================
    //Daftar Referensi Partner
    //=====================
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "pelabuhanMuat")
    private List<DokumenPabean> dokumenByPelabuhanMuat;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "pelabuhanBongkar")
    private List<DokumenPabean> dokumenByPelabuhanBongkar;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "pelabuhanTransit")
    private List<DokumenPabean> dokumenByPelabuhanTransit;

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

    public Referensi getNegara() {
        return negara;
    }

    public void setNegara(Referensi negara) {
        this.negara = negara;
    }

    public List<DokumenPabean> getDokumenByPelabuhanBongkar() {
        return dokumenByPelabuhanBongkar;
    }

    public void setDokumenByPelabuhanBongkar(List<DokumenPabean> dokumenByPelabuhanBongkar) {
        this.dokumenByPelabuhanBongkar = dokumenByPelabuhanBongkar;
    }

    public List<DokumenPabean> getDokumenByPelabuhanMuat() {
        return dokumenByPelabuhanMuat;
    }

    public List<DokumenPabean> getDokumenByPelabuhanTransit() {
        return dokumenByPelabuhanTransit;
    }
}
