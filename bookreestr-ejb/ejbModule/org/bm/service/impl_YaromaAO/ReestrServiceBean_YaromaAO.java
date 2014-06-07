/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.ReestrEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Reestr_YaromaAO;
import org.bm.service_YaromaAO.ReestrService_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Reestr")
public class ReestrServiceBean_YaromaAO implements ReestrService_YaromaAO {
	
	@EJB
	ReestrEjbBean_YaromaAO	dao;
	
	public List<Reestr_YaromaAO> getAll() {        
		return dao.getAll();
	}	
	
	public Reestr_YaromaAO get(int id) {
		return dao.get(id);
	}	
	
	@Override
	public int add(Reestr_YaromaAO r) {
		return dao.add(r);		
	}	
	
	public void delete(int id) {
		dao.delete(id);		
	}

	/* (non-Javadoc)
	 * @see org.bm.service_YaromaAO.ReaderService_YaromaAO#update(org.bm.model_YaromaAO.Reader_YaromaAO)
	 */
	@Override
	public void update(Reestr_YaromaAO r) {
		dao.update(r);		
	}	
}
