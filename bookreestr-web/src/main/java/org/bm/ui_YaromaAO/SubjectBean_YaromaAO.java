/**
 * 
 */
package org.bm.ui_YaromaAO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.bm.service.subject.SubjectServiceBean_YaromaAO;
import org.bm.service.subject.SubjectServiceBean_YaromaAOServiceLocator;
import org.bm.service.subject.SubjectYaromaAO;
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
public class SubjectBean_YaromaAO extends GridBean_YaromaAO<SubjectYaromaAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridSubjects"; 
	
	private static final String ADDRESS = "http://localhost:8080/SubjectServiceBean_YaromaAOService/SubjectServiceBean_YaromaAO?wsdl";
	
	SubjectServiceBean_YaromaAO sb;
	
	@PostConstruct
    public void init() {
		try {
			sb = new SubjectServiceBean_YaromaAOServiceLocator().getSubject(new java.net.URL(ADDRESS));
			
			items = new ArrayList<SubjectYaromaAO>();
			for (SubjectYaromaAO s: sb.getAllSubjects())
			{
				items.add(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void add(){
		
		SubjectYaromaAO item = new SubjectYaromaAO();
		try
		{
			item.setId(sb.getNewSubjectId());
			items.add(item);
		}
		catch (RemoteException e) {		
			e.printStackTrace();
		}
		
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
		SubjectYaromaAO s = (SubjectYaromaAO)e.getObject();
		
		try
		{
			if (isNew) {			
				sb.addSubject(s);
				isNew = false;
		}
		else
			sb.updateSubject(s);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			SubjectYaromaAO s = (SubjectYaromaAO)o;
			try {
				sb.deleteSubject(s.getId());
			} 
			catch (RemoteException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			items.remove(s);
		}
		
		isSelected = false;
	} 
	
	public SubjectYaromaAO get(int id) throws RemoteException{
		
		return sb.getSubject(id);
	}
}

