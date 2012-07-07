/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.djbc.spring.repository;

import gov.djbc.spring.filter.FilterItem;
import java.util.List;

/**
 *
 * @author User
 */
public interface FilterRepository<B> {

    public Iterable<B> filter(List<FilterItem> filterItem);
}
