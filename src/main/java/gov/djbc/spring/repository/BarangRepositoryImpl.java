/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.repository;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.sql.JPASQLQuery;
import com.mysema.query.types.expr.StringExpression;
import gov.djbc.spring.entity.Barang;
import gov.djbc.spring.entity.QBarang;
import gov.djbc.spring.filter.Fielderable;
import gov.djbc.spring.filter.Fentry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 *
 * @author User
 */
public class BarangRepositoryImpl extends QueryDslRepositorySupport implements BarangRepositoryCustom {

    private static List<Fielderable> fields = new ArrayList<Fielderable>();

    static {
        fields.add(new Fielderable<StringExpression>("nama", QBarang.barang.nama, "like"));
    }

    public Iterable<Barang> filter(List<Fentry> filterItem) {
        QBarang b = QBarang.barang;
        JPQLQuery q = from(b);
        q.where(QBarang.barang.nama.containsIgnoreCase("susu"));
        return q.list(b);
    }
}
