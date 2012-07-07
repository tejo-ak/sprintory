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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class JurnalStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = BarangDiInventory.class, fetch = FetchType.EAGER)
    private BigDecimal jumlah;
    private BigDecimal harga;
    private BigDecimal total;
    private BigDecimal saldo;
    @Column(length = 128)
    private String keterangan;
    @Column(length = 1)
    private String kredebit;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 19)
    private Date created;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jurnal", targetEntity = LayerJurnal.class)
    private List<LayerJurnal> layerJurnal;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKredebit() {
        return kredebit;
    }

    public void setKredebit(String kredebit) {
        this.kredebit = kredebit;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<LayerJurnal> getLayerJurnal() {
        return layerJurnal;
    }
}
