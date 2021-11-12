package com.en.BookFilmApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.en.BookFilmApi.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

	Film findByTitle(String title);

}