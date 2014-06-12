/**
 * 
 */
package org.bm.ejb_YaromaAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bm.model_YaromaAO.Person_YaromaAO;

/**
 * @author Black Moon
 *
 */
@LocalBean
@Stateless
public class PersonEjbBean_YaromaAO extends DBEjbBean_YaromaAO<Person_YaromaAO> {
	
	@Override
	public int add(Person_YaromaAO p) {        
		
		String passwd = p.getPassword(), salt = null;
		
		if (passwd != null && passwd.length() > 0) {
			salt = RandomStringUtils.random(16, "abcdef0123456789");
			passwd = DigestUtils.sha256Hex(passwd + "{" + salt + "}");
		}
		p.setPassword(passwd);
		p.setSalt(salt);
		
        return super.add(p);
	}	

	public List<Person_YaromaAO> getAll() {        
		TypedQuery<Person_YaromaAO> namedQuery = em.createNamedQuery("Person.getAll", Person_YaromaAO.class);
        return namedQuery.getResultList();
	}	
	
	public Person_YaromaAO get(int id) {
		return em.find(Person_YaromaAO.class, id);
	}
	
	public Person_YaromaAO getByLogin(String login) {		
		return (Person_YaromaAO)em.createQuery("SELECT p FROM Person p WHERE p.login = ?").setParameter(1, login).getSingleResult();
	}
	
	public int getNewId(){
		return (int)em.createQuery("SELECT MAX(p.id) + 1 FROM Person p").getSingleResult();		
	}		
	
	public void delete(int id) {
		super.delete(get(id));		
	}
	
	@Override
	public void update(Person_YaromaAO p) {
		String passwd = p.getPassword(), salt = null;
		
		if (passwd != null && passwd.length() > 0) {
			salt = RandomStringUtils.random(16, "abcdef0123456789");
			passwd = DigestUtils.sha256Hex(passwd + "{" + salt + "}");
		}
		else
		{
			Person_YaromaAO old = getByLogin(p.getLogin());
			passwd = old.getPassword();			
			salt = old.getSalt();
		}
		
		p.setPassword(passwd);
		p.setSalt(salt);
		
		super.update(p);
	}
}
