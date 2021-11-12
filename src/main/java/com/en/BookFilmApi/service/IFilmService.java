package com.en.BookFilmApi.service;

import java.util.List;

import com.en.BookFilmApi.model.Film;

public interface IFilmService {

	List<Film> findAll();

	Film findById(Long id);

	Film findByTitle(String title);

	Film save(Film film);

	void deleteById(Long id);

	void deleteAll();
}
