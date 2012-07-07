/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Referensi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long grup;
    @Column(length = 6)
    private String kode;
    @Column(length = 32)
    private String nama;
    @Column(length = 512)
    private String keterangan;
    @Column(length = 64)
    private String nilai;
    private Long num;
    //=====================
    //list of reference type
    //=====================
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenis", targetEntity = Inventory.class)
    List<Inventory> inventoryByJenis;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "metode", targetEntity = Inventory.class)
    List<Inventory> inventoryByMetode;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenisId", targetEntity = Partner.class)
    List<Partner> partnerByJenisId;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenisApi", targetEntity = Partner.class)
    List<Partner> partnerByJenisApi;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenisUsaha", targetEntity = Partner.class)
    List<Partner> partnerByJenisUsaha;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "bentukUsaha", targetEntity = Partner.class)
    List<Partner> partnerByBentukUsaha;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "tipe", targetEntity = Partner.class)
    List<Partner> partnerByTipe;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "negara", targetEntity = Partner.class)
    List<Partner> partnerByNegara;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenis", targetEntity = DokumenPabean.class)
    List<DokumenPabean> dokumenByJenis;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenisAsuransi", targetEntity = DokumenPabean.class)
    List<DokumenPabean> dokumenByJenisAsuransi;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "valuta", targetEntity = DokumenPabean.class)
    List<DokumenPabean> dokumenByValuta;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "tujuanBarang", targetEntity = DokumenPabean.class)
    List<DokumenPabean> dokumenByTujuanBarang;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "kondisi", targetEntity = DokumenPabean.class)
    List<DokumenPabean> dokumenByKondisi;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "negara", targetEntity = Pelabuhan.class)
    List<Pelabuhan> pelabuhanByNegara;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jenis", targetEntity = DokumenDokumenPabean.class)
    List<DokumenDokumenPabean> dokumenPabeanByJenis;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "kemasan", targetEntity = KemasanDokumenPabean.class)
    List<KemasanDokumenPabean> kemasanByJenis;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "ukuran", targetEntity = KontainerDokumenPabean.class)
    List<KontainerDokumenPabean> kontainerByUkuran;
    @OneToMany(mappedBy = "jenis", targetEntity = KontainerDokumenPabean.class)
    List<KontainerDokumenPabean> kontainerByJenis;

    public Long getGrup() {
        return grup;
    }

    public void setGrup(Long grup) {
        this.grup = grup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
