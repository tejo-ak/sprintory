/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.repository;

import gov.djbc.spring.entity.BarangDiInventory;
import gov.djbc.spring.entity.QBarangDiInventory;
import gov.djbc.spring.filter.Fentry;
import java.util.List;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 *
 * @author User
 */
public class BarangDiInventoryRepositoryImpl extends QueryDslRepositorySupport implements BarangDiInventoryRespositoryCustom {

    public Iterable<BarangDiInventory> filter(List<Fentry> filterItem) {
        return from(QBarangDiInventory.barangDiInventory).list(QBarangDiInventory.barangDiInventory);
    }
}
