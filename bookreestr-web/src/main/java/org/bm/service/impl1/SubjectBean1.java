/**
 * 
 */
package org.bm.service.impl1;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model1.Subject;

/**
 * @author Black Moon
 *
 */
public class SubjectBean1 extends DBBean<Subject> {
	
	public List<Subject> getAll() {        
		TypedQuery<Subject> namedQuery = em.createNamedQuery("Subject1.getAll", Subject.class);
        return namedQuery.getResultList();
	}	
	
	public Subject get(int id) {
		return em.find(Subject.class, id);
	}
	
	
	public int getNewId(){
		return (int)em.createQuery("SELECT MAX(s.id) + 1 FROM Subject1 s").getSingleResult();		
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
