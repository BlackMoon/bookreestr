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

import org.bm.service.reader.ReaderServiceBean_YaromaAO;
import org.bm.service.reader.ReaderServiceBean_YaromaAOServiceLocator;
import org.bm.service.reader.ReaderYaromaAO;
import org.bm.service.subject.SubjectYaromaAO;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;

/**
 * @author Black Moon
 *
 */
@ManagedBean(name="readerBean")
@ViewScoped
public class ReaderBean_YaromaAO extends GridBean_YaromaAO<ReaderYaromaAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridReaders"; 
	
	private static final String ADDRESS = "http://localhost:8080/ReaderServiceBean_YaromaAOService/ReaderServiceBean_YaromaAO?wsdl";
	
	ReaderServiceBean_YaromaAO rb;
	
	@PostConstruct
    public void init() {
		try {
			rb = new ReaderServiceBean_YaromaAOServiceLocator().getReader(new java.net.URL(ADDRESS));
			
			items = new ArrayList<ReaderYaromaAO>();
			for (ReaderYaromaAO r: rb.getAllReaders())
			{
				items.add(r);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void add(){
		
		ReaderYaromaAO item = new ReaderYaromaAO();
		try{
			item.setId(rb.getNewReaderId());
			items.add(item);		
		} catch (RemoteException e) {
		// TODO Auto-generated catch block
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
		ReaderYaromaAO r = (ReaderYaromaAO)e.getObject();
		
		try
		{
			if (isNew) {			
				rb.addReader(r);
				isNew = false;
			}
			else
				rb.updateReader(r);
		}
		catch (RemoteException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			ReaderYaromaAO r = (ReaderYaromaAO)o;
			try {
				rb.deleteReader(r.getId());
			} 
			catch (RemoteException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			items.remove(r);
		}
		
		isSelected = false;
	}
	
	public ReaderYaromaAO get(int id) throws RemoteException{
		
		return rb.getReader(id);
	}
}

