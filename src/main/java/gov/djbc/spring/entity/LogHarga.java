/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
public class LogHarga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal harga;
    @Temporal(TemporalType.DATE)
    private Date awal;
    @Temporal(TemporalType.DATE)
    private Date akhir;
    @Column(length = 128)
    private String keterangan;
    @ManyToOne(fetch = FetchType.LAZY)
    private Barang barang;
}
