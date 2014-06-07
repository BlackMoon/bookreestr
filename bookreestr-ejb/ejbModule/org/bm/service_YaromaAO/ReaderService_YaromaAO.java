/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model_YaromaAO.Reader_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface ReaderService_YaromaAO {
	List<Reader_YaromaAO> getAll(); 	
	Reader_YaromaAO get(int id);
	
	int add(Reader_YaromaAO r);
	int getNewId();	
	void delete(int id);
	void update(Reader_YaromaAO r);
}
