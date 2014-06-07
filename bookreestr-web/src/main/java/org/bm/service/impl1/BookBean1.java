/**
 * 
 */
package org.bm.service.impl1;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model1.Book;
import org.bm.model1.Subject;

/**
 * @author Black Moon
 *
 */
public class BookBean1 extends DBBean<Book>  {
	
	private Subject loadSubject(int id){
		return (Subject)em.createQuery("SELECT s FROM Subject s WHERE s.id = ?").setParameter(1, id).getSingleResult();
	}
	
	@Override
	public int add(Book b) {
		b.setSubject(loadSubject(b.getSubjectid()));
        return super.add(b);
	}	
	
	
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
	
	@Override
	public void update(Book b) {
		b.setSubject(loadSubject(b.getSubjectid()));
		super.update(b);
	}
}
