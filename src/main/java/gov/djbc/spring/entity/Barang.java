/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Barang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(length = 32)
    private String nama;
    @Column(length = 64)
    private String merk;
    private BigDecimal saldo;
    private BigDecimal harga;
    @Column(length = 6)
    private String satuan;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    private Date created;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = BarangDiInventory.class, mappedBy = "barang")
    private List<BarangDiInventory> barangs;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = LogHarga.class, mappedBy = "barang")
    private List<LogHarga> logharga;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = PembelianItem.class, mappedBy = "barang")
    private List<PembelianItem> dibeli;
    @OneToMany(targetEntity = BarangDokumenPabean.class, mappedBy = "barang")
    private List<BarangDokumenPabean> didokumen;

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

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<BarangDiInventory> getBarangs() {
        return barangs;
    }

    public List<LogHarga> getLogharga() {
        return logharga;
    }

    public List<PembelianItem> getDibeli() {
        return dibeli;
    }
}
