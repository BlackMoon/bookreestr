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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bm.model.Person;
import org.bm.service.PersonInterface1;

/**
 * @author Black Moon
 *
 */
public class PersonBean1 extends DBBean<Person> implements PersonInterface1 {
	
	@Override
	public int add(Person p) {        
		
		String passwd = p.getPassword(), salt = null;
		
		if (passwd != null && passwd.length() > 0) {
			salt = RandomStringUtils.random(16, "abcdef0123456789");
			passwd = DigestUtils.sha256Hex(passwd + "{" + salt + "}");
		}
		p.setPassword(passwd);
		p.setSalt(salt);
		
        return super.add(p);
	}	

	public List<Person> getAll() {        
		TypedQuery<Person> namedQuery = em.createNamedQuery("Person.getAll", Person.class);
        return namedQuery.getResultList();
	}	
	
	public Person get(int id) {
		return em.find(Person.class, id);
	}
	
	public Person get(String login) {		
		return (Person)em.createQuery("SELECT p FROM Person p WHERE p.login = ?").setParameter(1, login).getSingleResult();
	}
	
	public int getNewId(){
		return (int)em.createQuery("SELECT MAX(p.id) + 1 FROM Person p").getSingleResult();		
	}		
	
	public void delete(int id) {
		super.delete(get(id));		
	}
	
	@Override
	public void update(Person p) {
		String passwd = p.getPassword(), salt = null;
		
		if (passwd != null && passwd.length() > 0) {
			salt = RandomStringUtils.random(16, "abcdef0123456789");
			passwd = DigestUtils.sha256Hex(passwd + "{" + salt + "}");
		}
		p.setPassword(passwd);
		p.setSalt(salt);
		
		super.update(p);;
	}
}
