/**
 * 
 */
package org.bm.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.bm.model.Person;
import org.bm.service.PersonInterface1;

/**
 * @author Black Moon
 *
 */
public class PersonBean1 implements PersonInterface1 {
	
	EntityManager em = Persistence.createEntityManagerFactory("DS").createEntityManager();	
	
	@Override
	public List<Person> getAll() {        
		TypedQuery<Person> namedQuery = em.createNamedQuery("Person.getAll", Person.class);
        return namedQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.bm.service.PersonInterface1#add(org.bm.model.Person)
	 */
	@Override
	public Person add(Person p) {
		em.getTransaction().begin();
        Person newItem = em.merge(p);
        em.getTransaction().commit();
        return newItem;
	}

	/* (non-Javadoc)
	 * @see org.bm.service.PersonInterface1#get(int)
	 */
	@Override
	public Person get(int id) {
		return em.find(Person.class, id);
	}

	/* (non-Javadoc)
	 * @see org.bm.service.PersonInterface1#delete(int)
	 */
	@Override
	public void delete(int id) {
		em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see org.bm.service.PersonInterface1#update(org.bm.model.Person)
	 */
	@Override
	public void update(Person p) {
		
		
		em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
	}		
}
