/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Partner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15)
    private String npwp;
    @Column(length = 15)
    private String siup;
    @Column(length = 15)
    private String tdp;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenisId;
    @Column(length = 24)
    private String nomorId;
    @Column(length = 64)
    private String nama;
    @Column(length = 64)
    private String pemilik;
    @Column(length = 256)
    private String alamat;
    @Column(length = 12)
    private String area;
    @Column(length = 16)
    private String telp;
    @Column(length = 64)
    private String email;
    @Column(length = 24)
    private String nomorSk;
    @Temporal(TemporalType.DATE)
    private Date tanggalSk;
    @Column(length = 24)
    private String niper;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenisApi;
    @Column(length = 24)
    private String api;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenisUsaha;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi bentukUsaha;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi tipe;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi negara;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(length = 19)
    private Date created;
    //=====================
    //Daftar Referensi Partner
    //=====================
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "asal")
    private List<DokumenPabean> dokumenByAsal;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "tujuan")
    private List<DokumenPabean> dokumenByTujuan;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = DokumenPabean.class, mappedBy = "ppjk")
    private List<DokumenPabean> dokumenByPpjk;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Referensi getBentukUsaha() {
        return bentukUsaha;
    }

    public void setBentukUsaha(Referensi bentukUsaha) {
        this.bentukUsaha = bentukUsaha;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Referensi getJenisApi() {
        return jenisApi;
    }

    public void setJenisApi(Referensi jenisApi) {
        this.jenisApi = jenisApi;
    }

    public Referensi getJenisId() {
        return jenisId;
    }

    public void setJenisId(Referensi jenisId) {
        this.jenisId = jenisId;
    }

    public Referensi getJenisUsaha() {
        return jenisUsaha;
    }

    public void setJenisUsaha(Referensi jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
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

    public String getNiper() {
        return niper;
    }

    public void setNiper(String niper) {
        this.niper = niper;
    }

    public String getNomorId() {
        return nomorId;
    }

    public void setNomorId(String nomorId) {
        this.nomorId = nomorId;
    }

    public String getNomorSk() {
        return nomorSk;
    }

    public void setNomorSk(String nomorSk) {
        this.nomorSk = nomorSk;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Date getTanggalSk() {
        return tanggalSk;
    }

    public void setTanggalSk(Date tanggalSk) {
        this.tanggalSk = tanggalSk;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public Referensi getTipe() {
        return tipe;
    }

    public void setTipe(Referensi tipe) {
        this.tipe = tipe;
    }
}
