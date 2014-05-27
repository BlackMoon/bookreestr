package org.br.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BRSessionBean
 */
@Stateless
@LocalBean
public class BRSessionBean {

    public String method(){
    	return "SessionBean executed";
    }

}
