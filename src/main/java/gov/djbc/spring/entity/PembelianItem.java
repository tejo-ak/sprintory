/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
@Entity
public class PembelianItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal jumlah;
    private BigDecimal nilai;
    @Column(length = 128)
    private String keterangan;
    @ManyToOne(targetEntity = Pembelian.class, fetch = FetchType.LAZY)
    private Pembelian pembelian;
    @ManyToOne(targetEntity = Barang.class, fetch = FetchType.LAZY)
    private Barang barang;
    @OneToOne(targetEntity = JurnalStock.class)
    private JurnalStock jurnal;
}
