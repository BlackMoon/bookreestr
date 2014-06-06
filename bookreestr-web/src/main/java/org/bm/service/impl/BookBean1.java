/**
 * 
 */
package org.bm.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model.Book;

/**
 * @author Black Moon
 *
 */
public class BookBean1 extends DBBean<Book>  {
	
	public List<Book> getAll() {        
		TypedQuery<Book> namedQuery = em.createNamedQuery("Book.getAll", Book.class);
        return namedQuery.getResultList();
	}	
	
	public Book get(int id) {
		return em.find(Book.class, id);
	}	
	
	public int getNewId(){
		int newid = 1;
		
		Object o = em.createQuery("SELECT MAX(b.id) + 1 FROM Book b").getSingleResult();		
		return (o != null) ? (int)o : newid;		
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
