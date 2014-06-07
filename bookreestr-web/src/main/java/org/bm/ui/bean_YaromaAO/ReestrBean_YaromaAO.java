/**
 * 
 */
package org.bm.ui.bean_YaromaAO;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.bm.model.Reestr;
import org.bm.service.impl.ReestrBean1;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;

/**
 * @author Black Moon
 *
 */
@ManagedBean(name="reestrBean")
@ViewScoped
public class ReestrBean_YaromaAO extends GridBean_YaromaAO<Reestr> implements Serializable {
	

	//@WebServiceRef(wsdlLocation = "http://localhost:8080/PersonService/Catalog?wsdl")
    private ReestrBean1 rb = new ReestrBean1();
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridReestr"; 
	
	@PostConstruct
    public void init() {
        items = rb.getAll();
    }
	
	@Override
	public void add(){
		
		Reestr item = new Reestr();		
		items.add(item); 
		
		UIComponent u = FacesContext.getCurrentInstance().getViewRoot().findComponent(SELECTOR); 
		DataTable table = (DataTable)u;
		 
		RowState itemState = stateMap.get(item); 
		
		for (org.icefaces.ace.component.column.Column c : table.getColumns()) { 
			CellEditor editor = c.getCellEditor(); 
			
			if (editor != null)			
				itemState.addActiveCellEditor(editor);			
		}
		
		isNew = true;
	}
	
	@Override
	public void edit(RowEditEvent e){
		Reestr r = (Reestr)e.getObject();
		
		if (isNew) {			
			rb.add(r);
			isNew = false;
		}
		else
			rb.update(r);		
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			Reestr r = (Reestr)o;
			if (!isNew)
				rb.delete(r.getId());
			items.remove(r);
		}
		
		isSelected = false;
	}
}
