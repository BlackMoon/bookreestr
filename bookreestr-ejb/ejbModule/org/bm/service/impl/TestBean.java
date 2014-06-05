/**
 * 
 */
package org.bm.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Black Moon
 *
 */
@WebService
public class TestBean {
	
	@WebMethod
	public String Hello(){
		return "1";
	}
}
