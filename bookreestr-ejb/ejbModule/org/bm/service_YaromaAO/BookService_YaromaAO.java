/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model_YaromaAO.Book_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface BookService_YaromaAO {
	List<Book_YaromaAO> getAll();
	
	int add(Book_YaromaAO b);
	int getNewId();
	
	Book_YaromaAO get(int id);
	
	void delete(int id);
	void update(Book_YaromaAO b);
}
