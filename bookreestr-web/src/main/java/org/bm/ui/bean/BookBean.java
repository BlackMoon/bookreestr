/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.bm.model.Book;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class BookBean extends DataBean<Book> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
    public void init() {
        items = new ArrayList<Book>();
        items.add(new Book());
        
        Book b = new Book();
        b.setName("1");
        items.add(b);
    }
}
