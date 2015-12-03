/* 
 *  Controller that handles the web requests dispatched via appServlet.
 *  Autodetection configuration this class  in servlet-context.xml.
 *  
 */

package org.sanok.bookstore.controller;

import java.util.List;

import org.sanok.bookstore.model.Book;
import org.sanok.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles and retrieves book request
 */
@Controller
public class BookController {

	private static final Logger logger = LoggerFactory
			.getLogger(BookController.class);

	BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * Retrieves the main page
	 * get a list of all Books
	 * 
	 * @param model
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Home page requested");
		
		List<Book> bookList = bookService.getBookList();
	
		model.addAttribute("bookList", bookList);
		model.addAttribute("bookForm", new Book());
		
		return "home";
	}

	/**
	 * View page with name about
	 * 
	 * @param model
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		logger.info("About page requested");
		
		return "about";
	}

	/**
	 * View page with name contact
	 * 
	 * @param model
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		logger.info("About page requested");
	
		return "contact";
	}

	/**
	 * Create a new book by delegating the processing to bookService. 
	 * Displays a confirmation JSP page
	 *
	 * @param book
	 * @param result
	 * @return the string what redirects to method home from this class
	 */
	@RequestMapping(value = "/createBook", method = RequestMethod.POST)
	public String createBook(@ModelAttribute("bookForm") Book book,
			BindingResult result) {
		
		try {
			bookService.createBook(book);
		} catch (Exception e) {
			logger.error("Save Failed!");
			return "redirect:/";
		}
	
		return "redirect:/";
	}

	/**
	 * Deletes an existing book by delegating the processing to bookService.
	 * Displays a confirmation JSP page
	 *
	 * @param bookId to deleting the book by id
	 * @return the string what redirects to method home from this class
	 */
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("bookId") int bookId) {
		
		bookService.deleteBook(bookId);
		
		return "redirect:/";
	}

	/**
	 * Update an existing book by delegating the processing to bookService.
	 * Displays a confirmation JSP page
	 *
	 * @param book
	 * @param result
	 * @return the string what redirects to method home from this class
	 */
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book,
			BindingResult result) {
		
		try {
			bookService.updateBook(book);
		} catch (Exception e) {
			logger.error("Update Failed!");
			return "redirect:/";
		}
		
		return "redirect:/";
	}

	/**
	 * Open an existing book by delegating the processing to bookService.
	 * Displays a confirmation JSP page
	 *
	 * @param model
	 * @param bookname to open the book by name
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/book/{bookname}", method = RequestMethod.GET)
	public String getBook(Model model, @PathVariable String bookname) {
	
		Book book = bookService.getBookByBookName(bookname);
	
		model.addAttribute("book", book);
	
		return "user";
	}

}
