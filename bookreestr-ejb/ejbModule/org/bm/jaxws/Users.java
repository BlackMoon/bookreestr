/**
 * 
 */
package org.bm.jaxws;

import javax.ejb.Remote;
import javax.jws.WebService;

/**
 * @author Black Moon
 *
 */
@Remote
@WebService
public interface Users {
	String name();
}
