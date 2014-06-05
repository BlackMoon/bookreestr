/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.xml.ws.WebServiceRef;

import org.bm.model.Person;
import org.bm.model.Reestr;
import org.bm.service.impl.PersonBean1;
import org.icefaces.ace.event.RowEditCancelEvent;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.event.SelectEvent;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class ReestrBean extends GridBean<Reestr> implements Serializable {
	

	//@WebServiceRef(wsdlLocation = "http://localhost:8080/PersonService/Catalog?wsdl")
    //private PersonBean personService;
	
	private static final long serialVersionUID = 1L;
	private int rowIx = -1;
	
	@PostConstruct
    public void init() {
        items = new ArrayList<Reestr>();
        items.add(new Reestr());
        items.add(new Reestr());
        
    }
	
	public void selectListener(SelectEvent event) {
		rowIx = 1;
    }

	public int getRowIx() {
		return rowIx;
	}

	public void setRowIx(int rowIx) {
		this.rowIx = rowIx;
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

