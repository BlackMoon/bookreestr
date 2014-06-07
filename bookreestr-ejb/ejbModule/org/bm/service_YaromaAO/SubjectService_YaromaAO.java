/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model_YaromaAO.Subject_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface SubjectService_YaromaAO {
	
	List<Subject_YaromaAO> getAll();	
	Subject_YaromaAO get(int id);
	
	int add(Subject_YaromaAO r);
	int getNewId();
	void delete(int id);
	void update(Subject_YaromaAO s);
}
