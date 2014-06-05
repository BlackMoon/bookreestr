/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.bm.model.Person;
import org.bm.service.impl.PersonBean1;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class PersonBean extends DataBean<Person> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	PersonBean1 pb = new PersonBean1();
	
	@PostConstruct
    public void init() {
        items = pb.getAll();
    }
}
