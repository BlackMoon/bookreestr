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
import org.bm.service_YaromaAO.BookService_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Book")
public class BookServiceBean_YaromaAO implements BookService_YaromaAO {
	
	@EJB
	BookEjbBean_YaromaAO	dao;
	
	public List<Book_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Book_YaromaAO get(int id) {
		return dao.get(id);
	}	
	
	@Override
	public int add(Book_YaromaAO b) {
		return dao.add(b);		
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
	public void update(Book_YaromaAO b) {
		dao.update(b);		
	}	
}
