/**
 * 
 */
package org.bm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.bm.model.Key;

/**
 * @author Black Moon
 *
 */
@Entity
@Table(name="reestr")
@NamedQuery(name = "Reestr.getAll", query = "SELECT r from Reestr r")
public class Reestr implements Key{
	private int id;
	private int bookid;
	private int readerid;

	private Date startDate;
	private Date endDate;
	
	private Book book;
	private Reader reader;
	
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
	
	@OneToOne
	@JoinColumn(name="bookid")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}	
	
	@Transient
	public int getReaderid() {
		return readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	@OneToOne
	@JoinColumn(name="readerid")
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}	
}
