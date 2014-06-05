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

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class PersonBean extends GridBean<Person> implements Serializable {
	
	private static final long serialVersionUID = 1L;	 
	
	PersonBean1 pb = new PersonBean1();
	
	@PostConstruct
    public void init() {
        items = pb.getAll();
    }
	
	@Override
	public void add(){
		
		Person item = new Person();
		item.setId(pb.getNewId());
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
	
	@Override
	public void edit(RowEditEvent e){
		Person p = (Person)e.getObject();
		
		if (isNew) {			
			pb.add(p);
			isNew = false;
		}
		else
			pb.update(p);		
	}

	@Override
	public void delete(ActionEvent e) {
		
		for (Object o : stateMap.getSelected())
		{
			Person p = (Person)o;
			pb.delete(p.getId());
			items.remove(p);
		}
		
		isSelected = false;
	}
	
	public Person get(String username) {
		return pb.get(username);
	}
}
