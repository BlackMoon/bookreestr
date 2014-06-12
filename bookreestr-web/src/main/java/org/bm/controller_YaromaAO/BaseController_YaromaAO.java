/**
 * 
 */
package org.bm.controller_YaromaAO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

/**
 * @author Black Moon
 *
 */
@Controller
public abstract class BaseController_YaromaAO<T> {
	protected List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public abstract Map<String, Object> getAll();
}
