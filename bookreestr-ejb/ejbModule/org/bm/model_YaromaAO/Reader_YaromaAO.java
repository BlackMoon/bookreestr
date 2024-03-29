/**
 * 
 */
package org.bm.model_YaromaAO;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Black Moon
 *
 */
@Entity(name="Reader")
@Table(name="readers")
@NamedQuery(name = "Reader.getAll", query = "SELECT r from Reader r")
@XmlType
public class Reader_YaromaAO implements Key_YaromaAO {
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private Date birthday;
	
	private String lastname;
	private String firstname;
	private String middlename;	
	
	private List<Reestr_YaromaAO> reestrs;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() { 
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	@Override
	public String toString(){
		StringBuilder fio = new StringBuilder(lastname);
		
		if (firstname != null && firstname.length() > 0) {
			fio.append(" " + firstname.charAt(0) + ".");
			
			if (middlename != null && middlename.length() > 0) {
				fio.append(" " + middlename.charAt(0) + ".");
			}
		}
		
		return fio.toString();
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="reader", cascade = CascadeType.ALL, orphanRemoval=true)
	@XmlTransient
	public List<Reestr_YaromaAO> getReestrs() {
		return reestrs;
	}

	public void setReestrs(List<Reestr_YaromaAO> reestrs) {
		this.reestrs = reestrs;
	}
	
}
