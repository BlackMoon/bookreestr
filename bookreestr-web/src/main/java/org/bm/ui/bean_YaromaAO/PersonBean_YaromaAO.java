/**
 * 
 */
package org.bm.ui.bean_YaromaAO;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.rpc.ServiceException;

import org.bm.model1.Person;
import org.bm.service.impl_YaromaAO.PersonServiceBean_YaromaAO;
import org.bm.service.impl_YaromaAO.PersonServiceBean_YaromaAOServiceLocator;
import org.bm.service.impl_YaromaAO.PersonYaromaAO;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;

/**
 * @author Black Moon
 *
 */
@ManagedBean(name="personBean")
@ViewScoped
public class PersonBean_YaromaAO extends GridBean_YaromaAO<PersonYaromaAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridPersons"; 
	private static final String URL = "http://rhome:8080/PersonServiceBean_YaromaAOService/PersonServiceBean_YaromaAO";
	
	PersonServiceBean_YaromaAO pb;
	
	@PostConstruct
    public void init() {
		try {
			pb = new PersonServiceBean_YaromaAOServiceLocator().getPersonServiceBean_YaromaAOPort(new java.net.URL(URL));
			items = Arrays.asList(pb.getAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void add(){
		
		PersonYaromaAO item = new PersonYaromaAO();
		//item.setId(pb.getNewId());
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
		PersonYaromaAO p = (PersonYaromaAO)e.getObject();
		
		try 
		{	
			if (isNew)
			{ 
				pb.add(p);			
				isNew = false;
			}
			else
				pb.update(p);
		} 
		catch (Exception ex) { 
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(ActionEvent e) {
		
		for (Object o : stateMap.getSelected())
		{
			Person p = (Person)o;
			if (!isNew)
				
				try {
					pb.delete(p.getId());
				} 
				catch (RemoteException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			
			items.remove(p);
		}
		
		isSelected = false;
	}
	
	// for UserDetailsService
	public PersonYaromaAO get(String username) throws RemoteException {
		return pb.getByLogin(username);
	}
}
