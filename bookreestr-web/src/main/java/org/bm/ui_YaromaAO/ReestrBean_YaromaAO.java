/**
 * 
 */
package org.bm.ui_YaromaAO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.bm.service.person.PersonServiceBean_YaromaAO;
import org.bm.service.person.PersonServiceBean_YaromaAOServiceLocator;
import org.bm.service.person.PersonYaromaAO;
import org.bm.service.reestr.ReestrServiceBean_YaromaAO;
import org.bm.service.reestr.ReestrServiceBean_YaromaAOServiceLocator;
import org.bm.service.reestr.ReestrYaromaAO;
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
public class ReestrBean_YaromaAO extends GridBean_YaromaAO<ReestrYaromaAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridReestr";
	private static final String ADDRESS = "http://localhost:8080/ReestrServiceBean_YaromaAOService/ReestrServiceBean_YaromaAO?wsdl";
	
	ReestrServiceBean_YaromaAO rb;
	
	@ManagedProperty(value="#{bookBean}")
	private BookBean_YaromaAO bookBean;	
	
	@ManagedProperty(value="#{readerBean}")
	private ReaderBean_YaromaAO readerBean;	
	
	public BookBean_YaromaAO getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean_YaromaAO bookBean) {
		this.bookBean = bookBean;
	}

	public ReaderBean_YaromaAO getReaderBean() {
		return readerBean;
	}

	public void setReaderBean(ReaderBean_YaromaAO readerBean) {
		this.readerBean = readerBean;
	}

	@PostConstruct
    public void init() {
		items = new ArrayList<ReestrYaromaAO>();
		try {
			rb = new ReestrServiceBean_YaromaAOServiceLocator().getReestr(new java.net.URL(ADDRESS));
			
			items = new ArrayList<ReestrYaromaAO>();
			for (ReestrYaromaAO r: rb.getAllReestrs())
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
		
		ReestrYaromaAO item = new ReestrYaromaAO();		
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
		ReestrYaromaAO r = (ReestrYaromaAO)e.getObject();
		try 
		{	
			r.setBook(bookBean.get(r.getBookid()));
			r.setReader(readerBean.get(r.getReaderid()));
			
			if (isNew) {			
				rb.addReestr(r);				
				isNew = false;
			}
			else
				rb.updateReestr(r);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			ReestrYaromaAO r = (ReestrYaromaAO)o;
			if (!isNew)
				try {
					rb.deleteReestr(r.getId());
				} 
				catch (RemoteException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			
			items.remove(r);
		}
		
		isSelected = false;
	}
}

