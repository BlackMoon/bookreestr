/**
 * 
 */
package org.bm.service.impl1;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.bm.model1.Key;


/**
 * @author Black Moon
 *
 */
public abstract class DBBean<T extends Key> {
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
