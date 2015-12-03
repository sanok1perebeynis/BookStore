package org.sanok.bookstore.dao;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.sanok.bookstore.dao.impl.BookDaoImpl;
import org.sanok.bookstore.model.Book;
import org.sanok.bookstore.service.impl.BookServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookDaoTest {

	@Mock
	private SessionFactory sessionFactory;

	@Mock
	private Criteria mockCriteria;

	@Mock
	private Session session;

	@InjectMocks
	private BookDaoImpl bookDao;

	@Mock
	private Transaction mockTransaction;

	@Mock
	private Book book;


	
	@Before
	public void setup() {

		initMocks(this);
		when(sessionFactory.getCurrentSession()).thenReturn(session);

		bookDao = new BookDaoImpl();
		bookDao.setSessionFactory(sessionFactory);

	}

	@Test
	public void createBook() {

		bookDao.createBook(book);

		verify(sessionFactory).getCurrentSession();
		verify(session).save(book);
		verifyNoMoreInteractions(sessionFactory, session, book);

	}

	@Test
	public void deleteBook() {

		bookDao.deleteBook(book);
		

		verify(sessionFactory).getCurrentSession();
		verify(session).delete(book);
		verifyNoMoreInteractions(sessionFactory, session, book);

	}

	@Test
	public void updateBook() {

		bookDao.updateBook(book);

		verify(sessionFactory).getCurrentSession();
		verify(session).update(book);
		verifyNoMoreInteractions(sessionFactory, session, book);

	}

	

	
}
