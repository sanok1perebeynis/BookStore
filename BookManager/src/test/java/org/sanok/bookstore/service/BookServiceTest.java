/*
 * Testing methods from Service layer using junit and mockito.
 * 
 */

package org.sanok.bookstore.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.sanok.bookstore.dao.BookDao;
import org.sanok.bookstore.model.Book;
import org.sanok.bookstore.service.impl.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	private final String bookName = "Java";
	
	private final String firstName ="Herbert";
	
	private final String lastName  = "Shildt";
	
	private final int price = 400;
	
	private final String email = "Herbert@Shildt.com";
	
	
	@Mock
	private Book testBook;

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookDao bookDAO;

	@Before
	public void setup() {

		testBook = new Book();
		testBook.setBookname(bookName);
		testBook.setFirstname(firstName);
		testBook.setLastname(lastName);
		testBook.setPrice(price);
		testBook.setEmail(email);
	}

	/**
	 * Create and save new book.
	 */
	@Test
	public void createBook() {

		bookService.createBook(testBook);

		verify(bookDAO, times(1)).createBook(testBook);
		verifyNoMoreInteractions(bookDAO);

	}

	/**
	 * Delete the book.
	 */
	@Test
	public void deleteBook() {

		when(bookDAO.getBookById(1)).thenReturn(testBook);

		bookService.deleteBook(1);

		verify(bookDAO, times(1)).getBookById(1);
		verify(bookDAO, times(1)).deleteBook(testBook);
		verifyNoMoreInteractions(bookDAO);

	}

	/**
	 * Update the book.
	 */
	@Test
	public void updateBook() {

		bookService.updateBook(testBook);

		verify(bookDAO, times(1)).updateBook(testBook);
		verifyNoMoreInteractions(bookDAO);

	}

	/**
	 * Get list of books
	 */

	@Test
	public void getBookList() {
		List<Book> book = new ArrayList<>();
		bookDAO.getBookList();
		when(bookDAO.getBookList()).thenReturn(book);

		verify(bookDAO, times(1)).getBookList();
		verifyNoMoreInteractions(bookDAO);

	}

	/**
	 * Get the book by name
	 */
	@Test
	public void getBookByBookName() {

		when(bookDAO.getBookByBookName(bookName)).thenReturn(testBook);

		bookService.getBookByBookName(bookName);

		verify(bookDAO, times(1)).getBookByBookName(bookName);
		verifyNoMoreInteractions(bookDAO);

	}

	/**
	 * Get the book by id
	 */

	@Test
	public void getBookById() {

		when(bookDAO.getBookById(1)).thenReturn(testBook);

		bookService.getBookById(1);

		verify(bookDAO, times(1)).getBookById(1);
		verifyNoMoreInteractions(bookDAO);

	}

}
