/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.PersonEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Person_YaromaAO;
import org.bm.service_YaromaAO.PersonService_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Person")
public class PersonServiceBean_YaromaAO implements PersonService_YaromaAO {
	
	@EJB
	PersonEjbBean_YaromaAO	dao;
	
	public List<Person_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Person_YaromaAO get(int id) {
		return dao.get(id);
	}	
	
	@Override
	public int add(Person_YaromaAO p) {
		return dao.add(p);		
	}
	
	public int getNewId(){
		return dao.getNewId();		
	}	
	
	public void delete(int id) {
		dao.delete(id);		
	}

	/* (non-Javadoc)
	 * @see org.bm.service_YaromaAO.ReaderService_YaromaAO#update(org.bm.model_YaromaAO.Reader_YaromaAO)
	 */
	@Override
	public void update(Person_YaromaAO p) {
		dao.update(p);		
	}

	/* (non-Javadoc)
	 * @see org.bm.service_YaromaAO.PersonService_YaromaAO#getByLogin(java.lang.String)
	 */
	@Override
	public Person_YaromaAO getByLogin(String login) {
		return dao.getByLogin(login);
	}	
}
