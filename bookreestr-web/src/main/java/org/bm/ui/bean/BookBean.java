/**
 * 
 */
package org.bm.ui.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.bm.model.Book;
import org.bm.model.Subject;
import org.bm.service.impl.BookBean1;
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
public class BookBean extends GridBean<Book> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridBooks"; 
	
	BookBean1 bb = new BookBean1();
	
	@PostConstruct
    public void init() {
        items = bb.getAll();
    }
	
	@Override
	public void add(){
		
		Book item = new Book();
		item.setId(bb.getNewId());
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
		Book b = (Book)e.getObject();
		
		if (isNew) {			
			bb.add(b);
			isNew = false;
		}
		else
			bb.update(b);		
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			Book b = (Book)o;
			if (!isNew)
				bb.delete(b.getId());
			items.remove(b);
		}
		
		isSelected = false;
	}
	
	 public void subjectChange(ValueChangeEvent e) {
		 Object o = e.getNewValue();
		 if (o != null) {
			 
		 }
		 return;
	 }
}