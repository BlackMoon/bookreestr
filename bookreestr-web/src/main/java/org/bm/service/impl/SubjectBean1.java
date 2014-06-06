/**
 * 
 */
package org.bm.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import org.bm.model.Subject;

/**
 * @author Black Moon
 *
 */
public class SubjectBean1 extends DBBean<Subject> {
	
	public List<Subject> getAll() {        
		TypedQuery<Subject> namedQuery = em.createNamedQuery("Subject.getAll", Subject.class);
        return namedQuery.getResultList();
	}	
	
	public Subject get(int id) {
		return em.find(Subject.class, id);
	}
	
	
	public int getNewId(){
		int newid = 1;
		
		Object o = em.createQuery("SELECT MAX(s.id) + 1 FROM Subject s").getSingleResult();		
		return (o != null) ? (int)o : newid;		
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
