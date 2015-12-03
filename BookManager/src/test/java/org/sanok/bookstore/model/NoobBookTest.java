/*
 * Testing methods using junit.
 * Verify if the books can create and delete
 */

package org.sanok.bookstore.model;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sanok.bookstore.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class NoobBookTest {

	private static Log log = LogFactory.getLog(Book.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private BookServiceImpl BookService;

	private Book testBook;

	@Before
	public void setUpTestDataWithinTransaction() throws ParseException {
		testBook = new Book();
		testBook.setBookname("Java");
		testBook.setFirstname("Herbert");
		testBook.setLastname("Shildt");
		testBook.setPrice(400);
		testBook.setEmail("Herbert@Shildt.com");
		}

	@Test
	public void bookExists() {
		List<Book> BookList = BookService.getBookList();
		
		boolean contains = BookList.isEmpty();
		assertEquals(contains, false);
	}

	@Test
	public void createBook() {
		BookService.createBook(testBook);
		sessionFactory.getCurrentSession().flush();
		Book savedBook = BookService.getBookByBookName(testBook.getBookname());
		assertEquals(savedBook.getPrice(), testBook.getPrice());
		
	}
	
	
	
	@Test
	public void deleteBook() {
		
		BookService.deleteBook(1);
		sessionFactory.getCurrentSession().flush();
		
		Book deletedBook = BookService.getBookById(1);
		
		assertEquals(deletedBook, null);
		
	}
	


	

}
