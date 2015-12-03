/*
 * Provides CRUD operations with Book objects.
 * 
 */

package org.sanok.bookstore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sanok.bookstore.dao.BookDao;
import org.sanok.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
*
* Processing Books
* 
*/

@Repository
@Transactional(readOnly = true)
public class BookDaoImpl implements BookDao{

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	/**
	 * Create new book.
	 *
	 * @param book to create     
	 */
	@Transactional(readOnly = false)
	//@Override
	public void createBook(Book book) {
		this.sessionFactory.getCurrentSession().save(book);
	}
	
	/**
	 * Delete chosen book.
	 *
	 * @param book to delete     
	 */
	@Transactional(readOnly = false)
//	@Override
	public void deleteBook(Book book) {
		this.sessionFactory.getCurrentSession().delete(book);
	}
	
	/**
	 * Update chosen book.
	 *
	 * @param book to update     
	 */
	@Transactional(readOnly = false)
//	@Override
	public void updateBook(Book book) {
		this.sessionFactory.getCurrentSession().update(book);
	}

	/**
	 * Get list of books.
	 *
	 * @return the list
	 */
	//@Override
	public List<Book> getBookList() {
		// query by object type Book
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(Book.class);
		@SuppressWarnings("unchecked")
		List<Book> bookList = criteria.list();
		return bookList;
	}
	
	/**
	 * Get the books by name.
	 *
	 * @param bookname to find book
	 * 
	 * @return the book
	 */
	public Book getBookByBookName(String bookname) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Book.class);
		// search by field Bookname
		criteria.add(Restrictions.eq("bookname", bookname));
		// return unique result
		Book book = (Book) criteria.uniqueResult();
		return book;
	}

	/**
	 * Get the books by id.
	 *
	 * @param id to find book
	 * 
	 * @return the book
	 */
	public Book getBookById(int bookId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Book.class);
		criteria.add(Restrictions.eq("bookId", bookId));
		Book book = (Book) criteria.uniqueResult();
		return book;
	}



}
