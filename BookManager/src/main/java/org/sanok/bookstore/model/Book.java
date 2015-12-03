package org.sanok.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = -854530626840992392L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Integer bookId;

	@Column(name = "BOOKNAME", unique = true)
	private String bookname;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "EMAIL")
	private String email;

	public Book() {
	}

	public Book(String bookname, String firstname, String lastname, int price, String email) {
		this.bookname = bookname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.price = price;
		this.email = email;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookname=" + bookname + ", firstname=" + firstname + ", lastname="
				+ lastname + ", price=" + price + ", email=" + email + "]";
	}
}
