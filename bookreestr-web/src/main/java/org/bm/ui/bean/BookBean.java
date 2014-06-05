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
import javax.faces.event.ActionEvent;

import org.bm.model.Book;
import org.icefaces.ace.event.RowEditCancelEvent;
import org.icefaces.ace.event.RowEditEvent;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class BookBean extends GridBean<Book> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
    public void init() {
        items = new ArrayList<Book>();
        items.add(new Book());
        
        Book b = new Book();
        b.setName("1");
        items.add(b);
    }

	/* (non-Javadoc)
	 * @see org.bm.ui.bean.GridBean#add()
	 */
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.bm.ui.bean.GridBean#delete(javax.faces.event.ActionEvent)
	 */
	@Override
	public void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.bm.ui.bean.GridBean#edit(org.icefaces.ace.event.RowEditEvent)
	 */
	@Override
	public void edit(RowEditEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
