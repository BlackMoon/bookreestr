/**
 * 
 */
package org.bm.ui.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.RowEditEvent;
import org.icefaces.ace.event.SelectEvent;
import org.icefaces.ace.model.table.RowStateMap;

/**
 * @author Black Moon
 *
 */
public abstract class GridBean<T> {
	
	protected boolean 		isNew = false;
	protected boolean 		isSelected = false;	

	protected List<T> 		items;	
	protected RowStateMap 	stateMap = new RowStateMap();
	
	public abstract void add();
	public abstract void delete(ActionEvent e);
	public abstract void edit(RowEditEvent e);	
	
	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public RowStateMap getStateMap() {
		return stateMap;
	}

	public void setStateMap(RowStateMap stateMap) {
		this.stateMap = stateMap;
	}
	
	public boolean getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public void select(SelectEvent e){
		isSelected = true;
	}
	
	public void unselect(SelectEvent e){
		isSelected = false;
	}
}
