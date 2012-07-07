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
public class LayerStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal harga;
    private BigDecimal saldo;
    private BigDecimal nilai;
    @ManyToOne(targetEntity = BarangDiInventory.class)
    private BarangDiInventory barang;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 19)
    private Date created;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "layer", targetEntity = LayerJurnal.class)
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

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BarangDiInventory getBarang() {
        return barang;
    }

    public void setBarang(BarangDiInventory barang) {
        this.barang = barang;
    }

    public List<LayerJurnal> getLayerJurnal() {
        return layerJurnal;
    }

    
}
