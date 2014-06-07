/**
 * 
 */
package org.bm.model1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.bm.model1.Key;

/**
 * @author Black Moon
 *
 */
@Entity
@Table(name="subjects")
@NamedQuery(name = "Subject.getAll", query = "SELECT s from Subject s")
public class Subject implements Key {
	
	private int id;	
	private String name;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() { 
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}	

	public void setName(String name) {
		this.name = name;
	}

}
