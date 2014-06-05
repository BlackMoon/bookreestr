/**
 * 
 */
package org.bm.service;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model.Person;

/**
 * @author Black Moon
 *
 */
public interface PersonInterface1 {
	 Person add(Person p);
	 Person get(int id);
	 List<Person> getAll();
	 void delete(int id);	        
	 void update(Person item);
}
