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

import org.bm.model.Subject;
import org.bm.service.impl.SubjectBean1;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;

/**
 * @author Black Moon
 *
 */
@ManagedBean(name="subjectBean")
@ViewScoped 
public class SubjectBean_YaromaAO extends GridBean_YaromaAO<Subject> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridSubjects"; 
	
	SubjectBean1 sb = new SubjectBean1();
	
	@PostConstruct
    public void init() {
        items = sb.getAll();
    }
	
	@Override
	public void add(){
		
		Subject item = new Subject();
		item.setId(sb.getNewId());
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
		Subject s = (Subject)e.getObject();
		
		if (isNew) {			
			sb.add(s);
			isNew = false;
		}
		else
			sb.update(s);		
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			Subject s = (Subject)o;
			if (!isNew)
				sb.delete(s.getId());
			items.remove(s);
		}
		
		isSelected = false;
	}
}
