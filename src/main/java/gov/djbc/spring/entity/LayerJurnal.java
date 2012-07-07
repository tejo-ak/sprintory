/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class LayerJurnal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal jumlah;
    private BigDecimal total;
    @ManyToOne(targetEntity = LayerStock.class)
    private LayerStock layer;
    @ManyToOne(targetEntity = JurnalStock.class)
    private JurnalStock jurnal;

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

    public JurnalStock getJurnal() {
        return jurnal;
    }

    public void setJurnal(JurnalStock jurnal) {
        this.jurnal = jurnal;
    }

    public LayerStock getLayer() {
        return layer;
    }

    public void setLayer(LayerStock layer) {
        this.layer = layer;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
