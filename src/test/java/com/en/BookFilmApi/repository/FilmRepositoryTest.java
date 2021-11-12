package com.en.BookFilmApi.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.en.BookFilmApi.model.Film;

class FilmRepositoryTest {

	@Autowired
	Film film;
	
	
	@Test
	public void shouldReturnTitle() {
		
		assertNotNull((film.getTitle()));

	}
}
