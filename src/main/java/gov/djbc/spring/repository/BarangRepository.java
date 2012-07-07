/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.repository;

import gov.djbc.spring.entity.Barang;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface BarangRepository extends BarangRepositoryCustom, CrudRepository<Barang, Long> {
}
