/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class DokumenPabean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = Kantor.class)
    private Kantor kantor;
    @ManyToOne(targetEntity = Kantor.class)
    private Kantor kantorAwas;
    @ManyToOne(targetEntity = Kantor.class)
    private Kantor kantorBongkar;
    @ManyToOne(targetEntity = Kantor.class)
    private Kantor kantorPeriksa;
    private Long sysnum;
    @Column(length = 16)
    private String nomor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    @Column(length = 16)
    private String nomorDaftar;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalDaftar;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalEkspor;
    @Column(length = 16)
    private String sppb;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalSppb;
    @ManyToOne(targetEntity = Partner.class)
    private Partner asal;
    @ManyToOne(targetEntity = Partner.class)
    private Partner tujuan;
    @ManyToOne(targetEntity = Partner.class)
    private Partner ppjk;
    private BigDecimal netto;
    private BigDecimal bruto;
    private BigDecimal volume;
    private BigDecimal ndpbm;
    private BigDecimal fob;
    private BigDecimal freight;
    private BigDecimal asuransi;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenis;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenisAsuransi;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi valuta;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi tujuanBarang;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi kondisi;
    @ManyToOne(targetEntity = Pelabuhan.class)
    private Referensi pelabuhanBongkar;
    @ManyToOne(targetEntity = Pelabuhan.class)
    private Referensi pelabuhanTransit;
    @ManyToOne(targetEntity = Pelabuhan.class)
    private Referensi pelabuhanMuat;
    ////
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(length = 19)
    private Date created;
    //=====================
    //list of reference type
    //=====================
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "dokumen", targetEntity = BarangDokumenPabean.class)
    List<BarangDokumenPabean> barangs;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "dokumen", targetEntity = DokumenDokumenPabean.class)
    List<DokumenDokumenPabean> dokumens;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "dokumen", targetEntity = KontainerDokumenPabean.class)
    List<KontainerDokumenPabean> kontainers;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "dokumen", targetEntity = KemasanDokumenPabean.class)
    List<KemasanDokumenPabean> kemasans;
}
