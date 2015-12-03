/*
 * Testing methods from Controller using junit and mockito.
 * 
 */

package org.sanok.bookstore.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.sanok.bookstore.model.Book;
import org.sanok.bookstore.service.BookService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * Testing methods from Controller.
 * 
 */

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private final String bookName = "Java";
	
	private final String firstName ="Herbert";
	
	private final String lastName  = "Shildt";
	
	private final int price = 400;
	
	private final String email = "Herbert@Shildt.com";
	
	
	@InjectMocks
	private BookController bookController;

	@Mock
	private BookService bookService;

	@Mock
	private BindingResult result;

	@Mock
	private Model model;

	@Mock
	private Book book;

	@Spy
	List<Book> bookList = new ArrayList<Book>();

	private String nextPage;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		bookController = new BookController(bookService);
		
		nextPage = null;

		book = new Book();
		book.setBookname(bookName);
		book.setFirstname(firstName);
		book.setLastname(lastName);
		book.setPrice(price);
		book.setEmail(email);

		bookList.add(book);
	}

	/**
	 * Testing about method. This test check does that method return page about
	 */
	@Test
	public void about() throws Exception {

		nextPage = bookController.about(model);
		assertEquals("about", nextPage);
	}

	/**
	 * Testing contact method. This test check does that method return page
	 * contact
	 */
	@Test
	public void contact() throws Exception {

		nextPage = bookController.contact(model);
		assertEquals("contact", nextPage);

	}

	/**
	 * This test check does the book created and then redirect to page home
	 */
	@Test
	public void createBook() throws Exception {
		Book book1 = new Book();
		bookService.createBook(book1);

		assertEquals(bookController.createBook(book1, result), "redirect:/");

	}

	/**
	 * Check does the book deleted and then redirect to page home
	 */
	@Test
	public void deleteBook() throws Exception {
		doNothing().when(bookService).deleteBook(anyInt());
		assertEquals(bookController.deleteBook(1), "redirect:/");

	}

	/**
	 * Update book and redirect to page home
	 */
	@Test
	public void updateBook() throws Exception {
		doNothing().when(bookService).updateBook(any(Book.class));
		assertEquals(bookController.updateBook(book, result), "redirect:/");

	}

	/**
	 * Get the book by name and then redirect to page user
	 */
	@Test
	public void getBook() throws Exception {

		when(bookService.getBookByBookName(anyString())).thenReturn(book);

		assertEquals(bookController.getBook(model, anyString()), "user");
		assertNotNull(book.getBookname());
	}

}