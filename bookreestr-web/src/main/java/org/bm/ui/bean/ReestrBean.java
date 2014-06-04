/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.bm.model.Reestr;
import org.icefaces.ace.event.SelectEvent;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class ReestrBean extends DataBean<Reestr> implements Serializable {
	
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
}
