/**
 * 
 */
package org.bm.service.impl_YaromaAO;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.bm.service_YaromaAO.TestService;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService
public class TestServiceBean implements TestService {
	
	
	public String Hello(){
		return "1";
	}
}
