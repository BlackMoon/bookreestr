package org.bm.model_YaromaAO;
/**
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Black Moon
 *
 */
@Entity(name="Subject")
@Table(name="subjects")
@NamedQuery(name = "Subject.getAll", query = "SELECT s from Subject s")
@XmlType(namespace="http://subject.org")
public class Subject_YaromaAO implements Key_YaromaAO {
	
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
