/**
 * 
 */
package org.bm.ui_YaromaAO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.bm.service.book.BookServiceBean_YaromaAO;
import org.bm.service.book.BookServiceBean_YaromaAOServiceLocator;
import org.bm.service.book.BookYaromaAO;
import org.bm.service.subject.SubjectYaromaAO;
import org.icefaces.ace.component.celleditor.CellEditor;
import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.model.table.RowState;

/**
 * @author Black Moon
 *
 */
@ManagedBean(name="bookBean")
@ViewScoped  
public class BookBean_YaromaAO extends GridBean_YaromaAO<BookYaromaAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SELECTOR = "form2:gridBooks"; 
	
	private static final String ADDRESS = "http://localhost:8080/BookServiceBean_YaromaAOService/BookServiceBean_YaromaAO?wsdl";
	
	BookServiceBean_YaromaAO bb;
	
	@ManagedProperty(value="#{subjectBean}")
	private SubjectBean_YaromaAO subjectBean;	 
	
	public SubjectBean_YaromaAO getSubjectBean() {
		return subjectBean;
	}

	public void setSubjectBean(SubjectBean_YaromaAO subjectBean) {
		this.subjectBean = subjectBean;
	}

	@PostConstruct
    public void init() {
		try {
			bb = new BookServiceBean_YaromaAOServiceLocator().getBook(new java.net.URL(ADDRESS));
			
			items = new ArrayList<BookYaromaAO>();
			for (BookYaromaAO b: bb.getAllBooks())
			{
				items.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void add(){
		
		BookYaromaAO item = new BookYaromaAO();
		
		try
		{
			item.setId(bb.getNewBookId());
			items.add(item);
		} 
		catch (RemoteException e) {
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
		BookYaromaAO b = (BookYaromaAO)e.getObject();
		
		try
		{	 
			b.setSubject(subjectBean.get(b.getSubjectid()));
			
			if (isNew) {		
				bb.addBook(b);				
				isNew = false;
			}
			else 
				bb.updateBook(b);		
			
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(ActionEvent e) {
		for (Object o : stateMap.getSelected())
		{
			BookYaromaAO b = (BookYaromaAO)o;
			if (!isNew)
				try {
					bb.deleteBook(b.getId());
				} 
				catch (RemoteException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			items.remove(b);
		}
		
		isSelected = false;
	} 
	
	public BookYaromaAO get(int id) throws RemoteException{
		
		return bb.getBook(id);
	}
}