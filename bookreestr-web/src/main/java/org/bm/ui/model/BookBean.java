/**
 * 
 */
package org.bm.ui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class BookBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Book> books;
	
	@PostConstruct
    public void init() {
        books = new ArrayList<Book>();
        books.add(new Book());
        
        Book b = new Book();
        b.setName("1");
        books.add(b);
    }
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
