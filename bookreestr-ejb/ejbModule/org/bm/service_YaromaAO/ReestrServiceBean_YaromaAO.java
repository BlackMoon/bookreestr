/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.ejb_YaromaAO.ReestrEjbBean_YaromaAO;
import org.bm.model_YaromaAO.Reestr_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService(portName="Reestr", targetNamespace="http://reestr.org")
public class ReestrServiceBean_YaromaAO {
	
	@EJB
	ReestrEjbBean_YaromaAO	dao;
	
	public List<Reestr_YaromaAO> getAllReestrs() {        
		return dao.getAll();
	}	
	
	public Reestr_YaromaAO getReestr(int id) {
		return dao.get(id);
	}
	
	public int addReestr(Reestr_YaromaAO r) {
		return dao.add(r);		
	}	
	
	public void deleteReestr(int id) {
		dao.delete(id);		
	}
	
	public void updateReestr(Reestr_YaromaAO r) {
		dao.update(r);		
	}	
}
