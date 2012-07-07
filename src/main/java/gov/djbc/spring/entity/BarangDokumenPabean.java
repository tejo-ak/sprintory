/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class BarangDokumenPabean implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(targetEntity = DokumenPabean.class)
    private DokumenPabean dokumen;
    @ManyToOne(targetEntity = Barang.class)
    private Barang barang;
    private BigDecimal netto;
    private BigDecimal volume;
    private BigDecimal harga;
    private BigDecimal jumlah;
    private BigDecimal penyerahan;
    private BigDecimal trfBm;
    private BigDecimal trfPpnBm;
    private BigDecimal trfPph;
    private BigDecimal trfCukai;
    private BigDecimal byrBm;
    private BigDecimal byrPpnBm;
    private BigDecimal byrPph;
    private BigDecimal byrCukai;
    private BigDecimal tghBm;
    private BigDecimal tghPpnBm;
    private BigDecimal tghPph;
    private BigDecimal tghCukai;
    private BigDecimal cif;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public BigDecimal getByrBm() {
        return byrBm;
    }

    public void setByrBm(BigDecimal byrBm) {
        this.byrBm = byrBm;
    }

    public BigDecimal getByrCukai() {
        return byrCukai;
    }

    public void setByrCukai(BigDecimal byrCukai) {
        this.byrCukai = byrCukai;
    }

    public BigDecimal getByrPph() {
        return byrPph;
    }

    public void setByrPph(BigDecimal byrPph) {
        this.byrPph = byrPph;
    }

    public BigDecimal getByrPpnBm() {
        return byrPpnBm;
    }

    public void setByrPpnBm(BigDecimal byrPpnBm) {
        this.byrPpnBm = byrPpnBm;
    }

    public BigDecimal getCif() {
        return cif;
    }

    public void setCif(BigDecimal cif) {
        this.cif = cif;
    }

    public DokumenPabean getDokumen() {
        return dokumen;
    }

    public void setDokumen(DokumenPabean dokumen) {
        this.dokumen = dokumen;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
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

    public BigDecimal getNetto() {
        return netto;
    }

    public void setNetto(BigDecimal netto) {
        this.netto = netto;
    }

    public BigDecimal getPenyerahan() {
        return penyerahan;
    }

    public void setPenyerahan(BigDecimal penyerahan) {
        this.penyerahan = penyerahan;
    }

    public BigDecimal getTghBm() {
        return tghBm;
    }

    public void setTghBm(BigDecimal tghBm) {
        this.tghBm = tghBm;
    }

    public BigDecimal getTghCukai() {
        return tghCukai;
    }

    public void setTghCukai(BigDecimal tghCukai) {
        this.tghCukai = tghCukai;
    }

    public BigDecimal getTghPph() {
        return tghPph;
    }

    public void setTghPph(BigDecimal tghPph) {
        this.tghPph = tghPph;
    }

    public BigDecimal getTghPpnBm() {
        return tghPpnBm;
    }

    public void setTghPpnBm(BigDecimal tghPpnBm) {
        this.tghPpnBm = tghPpnBm;
    }

    public BigDecimal getTrfBm() {
        return trfBm;
    }

    public void setTrfBm(BigDecimal trfBm) {
        this.trfBm = trfBm;
    }

    public BigDecimal getTrfCukai() {
        return trfCukai;
    }

    public void setTrfCukai(BigDecimal trfCukai) {
        this.trfCukai = trfCukai;
    }

    public BigDecimal getTrfPph() {
        return trfPph;
    }

    public void setTrfPph(BigDecimal trfPph) {
        this.trfPph = trfPph;
    }

    public BigDecimal getTrfPpnBm() {
        return trfPpnBm;
    }

    public void setTrfPpnBm(BigDecimal trfPpnBm) {
        this.trfPpnBm = trfPpnBm;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
}
