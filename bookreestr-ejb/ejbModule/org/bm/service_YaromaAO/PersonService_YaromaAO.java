/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model_YaromaAO.Person_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface PersonService_YaromaAO {
	List<Person_YaromaAO> getAll();
	
	int add(Person_YaromaAO p);
	int getNewId();
		
	Person_YaromaAO get(int id);	
	Person_YaromaAO get(String login);
		
	void delete(int id);
	void update(Person_YaromaAO p);
}
