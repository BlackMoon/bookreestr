/**
 * 
 */
package org.bm.ui;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * @author Black Moon
 *
 */
@ManagedBean
@SessionScoped 
public class TabEvents implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String logoutLabel = "Вход";
	private String userInfo;
	
	public void tabChangeListener(ValueChangeEvent event) throws IOException {
		
		javax.faces.context.ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		
		int lastTab = 4;
		if (ectx.isUserInRole("ROLE_ADMIN")) 
			lastTab++;
		
		if (event.getNewValue().equals(lastTab))
		{			
			Principal user = ectx.getUserPrincipal();
			if (user != null) {
				setLogoutLabel("Выход");
				setUserInfo(user.getName());
			}
			else
				ectx.redirect("login");
		}
	}

	public String getLogoutLabel() {
		return logoutLabel;
	}

	public void setLogoutLabel(String logoutLabel) {
		this.logoutLabel = logoutLabel;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
}
