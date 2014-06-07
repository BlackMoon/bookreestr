/**
 * 
 */
package org.bm.service.impl1;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model1.Book;
import org.bm.model1.Reader;
import org.bm.model1.Reestr;

/**
 * @author Black Moon
 *
 */
public class ReestrBean1 extends DBBean<Reestr>  {
	
	private Book loadBook(int id){
		return (Book)em.createQuery("SELECT b FROM Book b WHERE b.id = ?").setParameter(1, id).getSingleResult();
	}
	
	private Reader loadReader(int id){
		return (Reader)em.createQuery("SELECT r FROM Reader r WHERE r.id = ?").setParameter(1, id).getSingleResult();
	}
	
	@Override
	public int add(Reestr r) {
		
		r.setBook(loadBook(r.getBookid()));
		r.setReader(loadReader(r.getReaderid()));
		
        return super.add(r);
	}	
	
	public List<Reestr> getAll() {        
		TypedQuery<Reestr> namedQuery = em.createNamedQuery("Reestr.getAll", Reestr.class);
        return namedQuery.getResultList();
	}	
	
	public Reestr get(int id) {
		return em.find(Reestr.class, id);
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
