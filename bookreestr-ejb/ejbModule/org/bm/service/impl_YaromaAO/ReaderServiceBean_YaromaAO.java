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
import org.bm.service_YaromaAO.ReaderService_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Reader")
public class ReaderServiceBean_YaromaAO implements ReaderService_YaromaAO {
	
	@EJB
	ReaderEjbBean_YaromaAO	dao;
	
	public List<Reader_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Reader_YaromaAO get(int id) {
		return dao.get(id);
	}	
	
	@Override
	public int add(Reader_YaromaAO r) {
		return dao.add(r);		
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
	public void update(Reader_YaromaAO r) {
		dao.update(r);		
	}	
}
