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
public class Jaminan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16)
    private String nomor;
    private BigDecimal nilai;
    @Column(length = 64)
    private String penjamin;
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(length = 16)
    private String nomorBukti;
    @Temporal(TemporalType.DATE)
    private Date tanggalBukti;
    @Temporal(TemporalType.DATE)
    private Date tempo;
}
