/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
public class KontainerDokumenPabean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16)
    private String nomor;
    @ManyToOne(targetEntity = DokumenPabean.class)
    private DokumenPabean dokumen;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenis;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi ukuran;

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

    public Referensi getJenis() {
        return jenis;
    }

    public void setJenis(Referensi jenis) {
        this.jenis = jenis;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Referensi getUkuran() {
        return ukuran;
    }

    public void setUkuran(Referensi ukuran) {
        this.ukuran = ukuran;
    }
}
