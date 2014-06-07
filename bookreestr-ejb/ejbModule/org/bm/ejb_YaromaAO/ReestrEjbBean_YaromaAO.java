/**
 * 
 */
package org.bm.ejb_YaromaAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.bm.model_YaromaAO.Book_YaromaAO;
import org.bm.model_YaromaAO.Reader_YaromaAO;
import org.bm.model_YaromaAO.Reestr_YaromaAO;

/**
 * @author Black Moon
 *
 */
@LocalBean
@Stateless
public class ReestrEjbBean_YaromaAO extends DBEjbBean_YaromaAO<Reestr_YaromaAO> {
	
	private Book_YaromaAO loadBook(int id){
		return (Book_YaromaAO)em.createQuery("SELECT b FROM Book b WHERE b.id = ?").setParameter(1, id).getSingleResult();
	}
	
	private Reader_YaromaAO loadReader(int id){
		return (Reader_YaromaAO)em.createQuery("SELECT r FROM Reader r WHERE r.id = ?").setParameter(1, id).getSingleResult();
	}
	
	@Override
	public int add(Reestr_YaromaAO r) {
		
		r.setBook(loadBook(r.getBookid()));
		r.setReader(loadReader(r.getReaderid()));
		
        return super.add(r);
	}	
	
	public List<Reestr_YaromaAO> getAll() {        
		TypedQuery<Reestr_YaromaAO> namedQuery = em.createNamedQuery("Reestr.getAll", Reestr_YaromaAO.class);
        return namedQuery.getResultList();
	}	
	
	public Reestr_YaromaAO get(int id) {
		return em.find(Reestr_YaromaAO.class, id);
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
