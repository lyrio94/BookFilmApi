package com.en.BookFilmApi.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.en.BookFilmApi.model.Book;



class BookRepositoryTest {

	@Autowired
	Book book;

	
	@Test
	public void shouldReturnTitle() {
		
		assertNotNull((book.getTitle()));

	}

}
