/*
 * Data Access Object to communicate with database.
 * Provides CRUD operations with Book objects.
 * 
 * @author Sanok
 */

package org.sanok.bookstore.dao;

import java.util.List;

import org.sanok.bookstore.model.Book;

/**
 * Communicate with database.
 */
public interface BookDao {

	/**
	 * Create and save new book.
	 *
	 */
	public void createBook(Book book);
	
	/**
	 * Delete the book.
	 *
	 */
	public void deleteBook(Book book);
	
	/**
	 * Update the book.
	 *
	 */
	public void updateBook(Book book);

	/**
	 * Get list of books
	 */
	public List<Book> getBookList();

	/**
	 * Get book by name
	 *
	 */
	public Book getBookByBookName(String bookname);
	
	/**
	 * Get book by id
	 *
	 */
	public Book getBookById(int bookId);
	
	
	
}