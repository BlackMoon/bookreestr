/**
 * 
 */
package org.bm.jaxws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * @author Black Moon
 *
 */
@Stateless
@WebService
public class UsersImpl implements Users {

	/* (non-Javadoc)
	 * @see org.bm.jaxws.Users#name()
	 */
	@Override	
	public String name() {
		return "Ok";
	}

}
