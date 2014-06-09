/**
 * 
 */
package org.bm.service_YaromaAO;

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
@WebService(portName="Reader", targetNamespace="http://reader.org")
public class ReaderServiceBean_YaromaAO {
	
	@EJB
	ReaderEjbBean_YaromaAO	dao;
	
	public List<Reader_YaromaAO> getAllReaders() {        
		return dao.getAll();
	}	
	
	public Reader_YaromaAO getReader(int id) {
		return dao.get(id);
	}	
		
	public int addReader(Reader_YaromaAO r) {
		return dao.add(r);		
	}
	
	public int getNewReaderId(){
		return dao.getNewId();		
	}	
	
	public void deleteReader(int id) {
		dao.delete(id);		
	}
	
	public void updateReader(Reader_YaromaAO r) {
		dao.update(r);		
	}	
}
