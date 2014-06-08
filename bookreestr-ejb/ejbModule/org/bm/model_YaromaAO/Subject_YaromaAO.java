package org.bm.model_YaromaAO;
/**
 * 
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
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
	
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String name;
	
    private List<Book_YaromaAO> books;
    
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="subject", cascade = CascadeType.ALL, orphanRemoval=true)	
	@XmlTransient
	public List<Book_YaromaAO> getBooks() {
		return books;
	}

	public void setBooks(List<Book_YaromaAO> books) {
		this.books = books;
	}
	
	public void addBook(Book_YaromaAO b) {
		if (!books.contains(b)) {
			books.add(b);
		}
	}

}
