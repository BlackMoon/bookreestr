/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.PersonEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Person_YaromaAO;
/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Person", targetNamespace="http://person.org")
public class PersonServiceBean_YaromaAO {
	
	@EJB
	PersonEjbBean_YaromaAO	dao;
	
	public List<Person_YaromaAO> getAllPersons() {        
		return dao.getAll();
	}	
	
	public Person_YaromaAO getPerson(int id) {
		return dao.get(id);
	}		
	
	public int addPerson(Person_YaromaAO p) {
		return dao.add(p);		
	}
	
	public int getNewPersonId(){
		return dao.getNewId();		
	}	
	
	public void deletePerson(int id) {
		dao.delete(id);		
	}
	
	public void updatePerson(Person_YaromaAO p) {
		dao.update(p);		
	}
	
	public Person_YaromaAO getByLogin(String login) {
		return dao.getByLogin(login);
	}	
}
