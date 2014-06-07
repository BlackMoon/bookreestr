/**
 * 
 */
package org.bm.ejb_YaromaAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.bm.model_YaromaAO.Reader_YaromaAO;

/**
 * @author Black Moon
 *
 */
@LocalBean
@Stateless
public class ReaderEjbBean_YaromaAO extends DBEjbBean_YaromaAO<Reader_YaromaAO> {
	
	public List<Reader_YaromaAO> getAll() {        
		TypedQuery<Reader_YaromaAO> namedQuery = em.createNamedQuery("Reader.getAll", Reader_YaromaAO.class);
        return namedQuery.getResultList();
	}	
	
	public Reader_YaromaAO get(int id) {
		return em.find(Reader_YaromaAO.class, id);
	}	
	
	@Override
	public int add(Reader_YaromaAO r) {
		return super.add(r);		
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
