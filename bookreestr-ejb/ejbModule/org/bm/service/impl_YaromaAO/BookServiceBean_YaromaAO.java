/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.BookEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Book_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Book")
public class BookServiceBean_YaromaAO {
	
	@EJB
	BookEjbBean_YaromaAO	dao;
	
	public List<Book_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Book_YaromaAO getBook(int id) {
		return dao.get(id);
	}
	
	public int addBook(Book_YaromaAO b) {
		return dao.add(b);		
	}
	
	public int getNewId(){
		return dao.getNewId();		
	}	
	
	public void deleteBook(int id) {
		dao.delete(id);		
	}
	
	public void updateBook(Book_YaromaAO b) {
		dao.update(b);		
	}	
}
