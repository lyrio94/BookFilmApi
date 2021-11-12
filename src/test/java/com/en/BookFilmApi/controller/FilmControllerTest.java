package com.en.BookFilmApi.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.en.BookFilmApi.model.Film;
import com.en.BookFilmApi.repository.FilmRepository;
import com.en.BookFilmApi.service.FilmService;


class FilmControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	//;
	Film newFilm;
	Film film;
	long id;
	
	@MockBean
	 private  FilmService filmService;
	private  FilmRepository repository;
	
	@Test
	public void findByTitle() throws Exception {
		when(filmService.findByTitle(""));
	}

	@Test
	public void testFilm() throws Exception {
		mockMvc.perform(get("/films")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.title").value("Harry Potter and the Philosopher's Stone"))
				.andExpect(jsonPath("$.country").value("06/26/1997"))
				.andExpect(jsonPath("$.releaseDate").value("1"))
				.andExpect(jsonPath("$.publisher").value("John Seale"))
				.andExpect(jsonPath("$.type").value("Film"));

	}
	@Test
	public void shouldReturnNotNullListFilm() {
		assertNotNull(filmService.findAll());

	}
	
	@Test
	public void shouldReturnNotNullNewtFilm() {
		assertNotNull(filmService.save(newFilm));

	}
	
	@Test
	public void shouldReturnTitle() {
		film.setTitle("Harry Potter and the Philosopher's Stone");
		film.setAuthor("J. K. Rowling");
		film.setCountry("United Kingdom");
		film.setReleaseDate("26/06/1997");
		film.setCinematography("Bloomsbury (UK)");
		film.setType("John Seale");
		
		assertNotNull(repository.findByTitle(film.getTitle()));

	}

}
	
