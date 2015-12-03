/*
 * Service Layer to make some connection between the DAO (Persistence)
 * layer and the Presentation (Web) layer.
 * 
 */

package org.sanok.bookstore.service.impl;

import java.util.List;

import org.sanok.bookstore.dao.BookDao;

import org.sanok.bookstore.model.Book;
import org.sanok.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BookService methods to make some actions with books.
 */

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	/**
	 * Create new book.
	 *
	 * @param book to create     
	 */
	//@Override
	public void createBook(Book book) {
		bookDao.createBook(book);
	}
	
	/**
	 * Delete chosen book.
	 *
	 * @param bookId to delete     
	 */
	//@Override
	public void deleteBook(int bookId) {
		Book bookToDelete = bookDao.getBookById(bookId);
		bookDao.deleteBook(bookToDelete);
	}
	
	/**
	 * Update chosen book.
	 *
	 * @param book to update     
	 */
	//@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	/**
	 * Get list of books.
	 *
	 * @return the list via BookDao
	 */
	//@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}
	
	/**
	 * Get the book by name.
	 *
	 * @param bookname to find book
	 * 
	 * @return the book via BookDao 
	 */
//	@Override
	public Book getBookByBookName(String bookname) {
		return bookDao.getBookByBookName(bookname);
	}

	/**
	 * Get the books by id.
	 *
	 * @param id to find book
	 * 
	 * @return the book via BookDao 
	 */
	//@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	
}
