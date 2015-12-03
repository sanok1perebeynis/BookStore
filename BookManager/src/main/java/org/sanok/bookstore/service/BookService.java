/*
 * Service Layer to make some connection between the DAO (Persistence)
 * layer and the Presentation (Web) layer.
 * 
 */

package org.sanok.bookstore.service;

import java.util.List;
import org.sanok.bookstore.model.Book;

/**
 * BookService methods to make some actions with books.
 */
public interface BookService {

	/**
	 * Create and save new book.
	 */
	public void createBook(Book book);

	/**
	 * Delete the book.
	 */
	public void deleteBook(int bookId);

	/**
	 * Update the book.
	 */
	public void updateBook(Book book);

	/**
	 * Get list of books
	 */
	public List<Book> getBookList();

	/**
	 * Get book by name
	 */
	public Book getBookByBookName(String bookname);

	/**
	 * Get book by id
	 */
	public Book getBookById(int bookId);

}
