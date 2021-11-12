package com.en.BookFilmApi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.en.BookFilmApi.model.Book;
import com.en.BookFilmApi.repository.BookRepository;
import com.en.BookFilmApi.service.BookService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class BookControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	//;
	Book newBook;
	Book book;
	long id;
	
	@MockBean
	 private  BookService bookService;
	private  BookRepository repository;
	
	@Test
	public void findByTitle() throws Exception {
		when(bookService.findByTitle(""));
	}

	@Test
	public void testBook() throws Exception {
		mockMvc.perform(get("/books")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.title").value("Harry Potter and the Philosopher's Stone"))
				.andExpect(jsonPath("$.country").value("06/26/1997"))
				.andExpect(jsonPath("$.releaseDate").value("1"))
				.andExpect(jsonPath("$.publisher").value("Bloomsbury (UK)"))
				.andExpect(jsonPath("$.type").value("Book"));

	}
	@Test
	public void shouldReturnNotNullListBook() {
		assertNotNull(bookService.findAll());

	}
	
	@Test
	public void shouldReturnNotNullNewtBook() {
		assertNotNull(bookService.save(newBook));

	}
	
	
	@Test
	public void shouldReturnTitle() {
		book.setTitle("Harry Potter and the Philosopher's Stone");
		book.setAuthor("J. K. Rowling");
		book.setCountry("United Kingdom");
		book.setReleaseDate("26/06/1997");
		book.setPublisher("Bloomsbury (UK)");
		book.setType("Book");
		
		assertNotNull(repository.findByTitle(book.getTitle()));

	}


}
