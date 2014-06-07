/**
 * 
 */
package org.bm.service_YaromaAO;

import javax.ejb.Remote;
import javax.jws.WebService;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface TestService {
	
	String Hello();
}
