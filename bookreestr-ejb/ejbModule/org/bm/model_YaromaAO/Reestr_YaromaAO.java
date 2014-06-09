/**
 * 
 */
package org.bm.model_YaromaAO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Black Moon
 *
 */
@Entity(name="Reestr")
@Table(name="reestr")
@NamedQuery(name = "Reestr.getAll", query = "SELECT r from Reestr r")
@XmlType(namespace="http://reestr.org")
public class Reestr_YaromaAO implements Key_YaromaAO{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int bookid;
	private int readerid;

	private Date startDate;
	private Date endDate;
	
	private Book_YaromaAO book;
	private Reader_YaromaAO reader;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Transient
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="bookid")
	public Book_YaromaAO getBook() {
		return book;
	}

	public void setBook(Book_YaromaAO book) {
		this.book = book;
		
		if (book!= null)
			bookid = book.getId();
	}	
	
	@Transient
	public int getReaderid() {
		return readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="readerid")
	public Reader_YaromaAO getReader() {
		return reader;		
	}

	public void setReader(Reader_YaromaAO reader) {
		this.reader = reader;
		
		if (reader!= null)
			readerid = reader.getId();
	}	
}
