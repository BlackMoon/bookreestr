/**
 * 
 */
package org.bm.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model.Reestr;

/**
 * @author Black Moon
 *
 */
public class ReestrBean1 extends DBBean<Reestr>  {
	
	public List<Reestr> getAll() {        
		TypedQuery<Reestr> namedQuery = em.createNamedQuery("Reestr.getAll", Reestr.class);
        return namedQuery.getResultList();
	}	
	
	public Reestr get(int id) {
		return em.find(Reestr.class, id);
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
