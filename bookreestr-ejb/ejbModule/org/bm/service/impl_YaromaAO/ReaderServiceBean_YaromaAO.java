/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.ReaderEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Reader_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Reader")
public class ReaderServiceBean_YaromaAO {
	
	@EJB
	ReaderEjbBean_YaromaAO	dao;
	
	public List<Reader_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Reader_YaromaAO getReader(int id) {
		return dao.get(id);
	}	
	
	
	public int addReader(Reader_YaromaAO r) {
		return dao.add(r);		
	}
	
	public int getNewId(){
		return dao.getNewId();		
	}	
	
	public void deleteReader(int id) {
		dao.delete(id);		
	}
	
	public void updateReader(Reader_YaromaAO r) {
		dao.update(r);		
	}	
}
