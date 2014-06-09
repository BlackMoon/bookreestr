/**
 * 
 */
package org.bm.model_YaromaAO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Black Moon
 *
 */
@Entity(name="Book")
@Table(name="books")
@NamedQuery(name = "Book.getAll", query = "SELECT b from Book b")
@XmlType(namespace="http://book.org")
public class Book_YaromaAO implements Key_YaromaAO {
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private int year;
	private int subjectid;
	
	private String name;
	private String author;
	private String publish;	
	
	private List<Reestr_YaromaAO> reestrs;
	private Subject_YaromaAO subject;
	
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	@Transient
	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subjectid", referencedColumnName="id")
	public Subject_YaromaAO getSubject() {
		return subject;
	}

	public void setSubject(Subject_YaromaAO subject) {
		this.subject = subject;
		
		if (subject != null)
			subjectid = subject.getId();
	}
	
	@Override
	public String toString(){
		return name + ". " + author;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="book", cascade = CascadeType.ALL, orphanRemoval=true)
	@XmlTransient
	public List<Reestr_YaromaAO> getReestrs() {
		return reestrs;
	}

	public void setReestrs(List<Reestr_YaromaAO> reestrs) {
		this.reestrs = reestrs;
	}
}
