/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Pembelian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sysnum;
    @Column(length = 16)
    private String nomor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(length = 19)
    private Date created;
    @JsonIgnore(value = true)
    @OneToMany(targetEntity = PembelianItem.class, mappedBy = "pembelian")
    private List<PembelianItem> item;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Long getSysnum() {
        return sysnum;
    }

    public void setSysnum(Long sysnum) {
        this.sysnum = sysnum;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
