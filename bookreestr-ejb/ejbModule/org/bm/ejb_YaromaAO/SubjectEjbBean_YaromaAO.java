/**
 * 
 */
package org.bm.ejb_YaromaAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.bm.model_YaromaAO.Subject_YaromaAO;

/**
 * @author Black Moon
 *
 */
@LocalBean
@Stateless
public class SubjectEjbBean_YaromaAO extends DBEjbBean_YaromaAO<Subject_YaromaAO> {
	
	public List<Subject_YaromaAO> getAll() {        
		TypedQuery<Subject_YaromaAO> namedQuery = em.createNamedQuery("Subject.getAll", Subject_YaromaAO.class);
        return namedQuery.getResultList();
	}	
	
	public Subject_YaromaAO get(int id) {
		return em.find(Subject_YaromaAO.class, id);
	}	
	
	@Override
	public int add(Subject_YaromaAO s) {
		return super.add(s);		
	}
	
	public int getNewId(){
		return (int)em.createQuery("SELECT MAX(s.id) + 1 FROM Subject s").getSingleResult();		
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
