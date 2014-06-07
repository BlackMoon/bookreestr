/**
 * 
 */
package org.bm.service_YaromaAO;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import org.bm.model_YaromaAO.Reestr_YaromaAO;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface ReestrService_YaromaAO {
	List<Reestr_YaromaAO> getAll();
	Reestr_YaromaAO get(int id);
	
	int add(Reestr_YaromaAO r);
	void delete(int id);
	void update(Reestr_YaromaAO r);
}
