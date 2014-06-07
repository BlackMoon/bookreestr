/**
 * 
 */
package org.bm.service.impl1;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bm.model1.Reader;

/**
 * @author Black Moon
 *
 */
public class ReaderBean1 extends DBBean<Reader> {
	
	public List<Reader> getAll() {        
		TypedQuery<Reader> namedQuery = em.createNamedQuery("Reader.getAll", Reader.class);
        return namedQuery.getResultList();
	}	
	
	public Reader get(int id) {
		return em.find(Reader.class, id);
	}	
	
	public int getNewId(){
		int newid = 1;
		
		Object o = em.createQuery("SELECT MAX(r.id) + 1 FROM Reader r").getSingleResult();		
		return (o != null) ? (int)o : newid;		
	}	
	
	public void delete(int id) {
		super.delete(get(id));		
	}	
}
