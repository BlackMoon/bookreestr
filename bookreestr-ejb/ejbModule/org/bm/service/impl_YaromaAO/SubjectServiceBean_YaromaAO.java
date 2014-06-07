/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.SubjectEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Subject_YaromaAO;
import org.bm.service_YaromaAO.SubjectService_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Subject")
public class SubjectServiceBean_YaromaAO implements SubjectService_YaromaAO {
	
	@EJB
	SubjectEjbBean_YaromaAO	dao;
	
	public List<Subject_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Subject_YaromaAO get(int id) {
		return dao.get(id);
	}	
	
	@Override
	public int add(Subject_YaromaAO s) {
		return dao.add(s);		
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
	public void update(Subject_YaromaAO s) {
		dao.update(s);		
	}	
}
