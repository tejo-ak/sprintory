/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
public class KemasanDokumenPabean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16)
    private String nomor;
    private BigDecimal jumlah;
    @ManyToOne(targetEntity = DokumenPabean.class)
    private DokumenPabean dokumen;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi kemasan;

    public DokumenPabean getDokumen() {
        return dokumen;
    }

    public void setDokumen(DokumenPabean dokumen) {
        this.dokumen = dokumen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    public Referensi getKemasan() {
        return kemasan;
    }

    public void setKemasan(Referensi kemasan) {
        this.kemasan = kemasan;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
