/**
 * 
 */
package org.bm.ejb_YaromaAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.bm.model_YaromaAO.Key_YaromaAO;

/**
 * @author Black Moon
 *
 */
public abstract class DBEjbBean_YaromaAO<T extends Key_YaromaAO> {
	protected EntityManager em = Persistence.createEntityManagerFactory("DS").createEntityManager();
	
	public int add(T item) {
		em.getTransaction().begin();
        T newItem = em.merge(item);
        em.getTransaction().commit();
        return newItem.getId();
	}
	
	public void delete(T item) {
		em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
	}
	
	public void update(T item) {		
		em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();        
	}		
}
