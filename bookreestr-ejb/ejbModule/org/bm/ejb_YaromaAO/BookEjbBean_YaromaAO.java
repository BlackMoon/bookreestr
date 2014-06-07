/**
 * 
 */
package org.bm.ejb_YaromaAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.bm.model_YaromaAO.Book_YaromaAO;
import org.bm.model_YaromaAO.Subject_YaromaAO;

/**
 * @author Black Moon
 *
 */
@LocalBean
@Stateless
public class BookEjbBean_YaromaAO extends DBEjbBean_YaromaAO<Book_YaromaAO> {
	
	private Subject_YaromaAO loadSubject(int id){
		return (Subject_YaromaAO)em.createQuery("SELECT s FROM Subject s WHERE s.id = ?").setParameter(1, id).getSingleResult();
	}
	
	@Override
	public int add(Book_YaromaAO b) {
		b.setSubject(loadSubject(b.getSubjectid()));
        return super.add(b);
	}	
	
	
	public List<Book_YaromaAO> getAll() {        
		TypedQuery<Book_YaromaAO> namedQuery = em.createNamedQuery("Book.getAll", Book_YaromaAO.class);
        return namedQuery.getResultList();
	}	
	
	public Book_YaromaAO get(int id) {
		return em.find(Book_YaromaAO.class, id);
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
	public void update(Book_YaromaAO b) {
		b.setSubject(loadSubject(b.getSubjectid()));
		super.update(b);
	}
}
