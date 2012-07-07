/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama;
    private String alamat;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi jenis;
    @ManyToOne(targetEntity = Referensi.class)
    private Referensi metode;
    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "inventory", targetEntity = BarangDiInventory.class)
    private List<BarangDiInventory> barangs;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public Referensi getMetode() {
        return metode;
    }

    public void setMetode(Referensi metode) {
        this.metode = metode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<BarangDiInventory> getBarangs() {
        return barangs;
    }

    public void setBarangs(List<BarangDiInventory> barangs) {
        this.barangs = barangs;
    }
}
