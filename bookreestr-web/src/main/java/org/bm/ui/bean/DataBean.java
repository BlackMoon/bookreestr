/**
 * 
 */
package org.bm.ui.bean;

import java.util.List;

/**
 * @author Black Moon
 *
 */
public abstract class DataBean<T> {
	protected List<T> items;
	
	
	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
