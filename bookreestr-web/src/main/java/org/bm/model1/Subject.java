/**
 * 
 */
package org.bm.model1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Black Moon
 *
 */
@Entity(name="Subject1")
@Table(name="subjects")
@NamedQuery(name = "Subject.getAll", query = "SELECT s from Subject1 s")
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
