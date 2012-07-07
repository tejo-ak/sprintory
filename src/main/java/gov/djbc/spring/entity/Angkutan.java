/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.entity;

import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
public class Angkutan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16)
    private String nomor;
}
