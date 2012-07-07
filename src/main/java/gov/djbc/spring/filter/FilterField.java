/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.filter;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.SimpleExpression;
import gov.djbc.spring.entity.QBarang;
import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class FilterField<E> {

    private String alias;
    private E field;
    private String operation;

    public FilterField() {
    }

    public FilterField(String alias, E field, String operation) {
        this.alias = alias;
        this.field = field;
        this.operation = operation;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public E getField() {
        return field;
    }

    public void setField(E field) {
        this.field = field;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
