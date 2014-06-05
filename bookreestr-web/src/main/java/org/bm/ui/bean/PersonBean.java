/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.bm.model.Person;
import org.bm.service.impl.PersonBean1;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;
import org.icefaces.ace.model.table.RowStateMap;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class PersonBean extends DataBean<Person> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isNew = false;
	private RowStateMap stateMap = new RowStateMap();

	PersonBean1 pb = new PersonBean1();
	
	@PostConstruct
    public void init() {
        items = pb.getAll();
    }
	
	public void add(){
		Person item = new Person(); 
		items.add(item); 
		
		UIComponent u = FacesContext.getCurrentInstance().getViewRoot().findComponent("form2:gridPersons"); 
		DataTable table = (DataTable)u;
		 
		RowState itemState = stateMap.get(item); 
		
		for (org.icefaces.ace.component.column.Column c : table.getColumns()) { 
			CellEditor editor = c.getCellEditor(); 
			
			if (editor != null)			
				itemState.addActiveCellEditor(editor);			
		}
		
		isNew = true;
	}
	
	public void edit(RowEditEvent e){
		Person item = new Person();
	}
	
	public void editCancel(RowEditEvent e){
		if (isNew)
		{
			
		}
	}
	
	public void delete(ActionEvent e) {
		List<?> selected = stateMap.getSelected();
		for (Object o : selected)
		{
			items.remove(o);
		}
		selected.clear();
	}
	
	
	public select() {
		
	}
	
	public RowStateMap getStateMap() {
		return stateMap;
	}

	public void setStateMap(RowStateMap stateMap) {
		this.stateMap = stateMap;
	}
}
