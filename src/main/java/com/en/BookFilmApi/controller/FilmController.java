package com.en.BookFilmApi.controller;



import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.en.BookFilmApi.model.Film;
import com.en.BookFilmApi.repository.FilmRepository;
import com.en.BookFilmApi.service.IFilmService;

@RestController
public class FilmController {

	@Autowired
	 private  IFilmService filmService;
	 private  FilmRepository repository;

	 FilmController(IFilmService filmService) {
		    this.filmService = filmService;
		  }

	  @GetMapping("/films")
	  List<Film> all() {
		  return (List<Film>) filmService.findAll();
	  }

	  @PostMapping("/newfilm")
	  Film newFilm(@RequestBody Film newFilm) {
	    return filmService.save(newFilm);
	  }
	  
	  @GetMapping("/films/{id}")
	  Object one(@PathVariable Long id) throws Throwable {	    
		  return filmService.findById(id).getId();
	  }
	  
	  @GetMapping("/films/{title}")
	  Film one(@PathVariable String title) throws Throwable {
	    
	    return filmService.findByTitle(title)
	      .orElseThrow(new Supplier<Throwable>() {
			@Override
			public Throwable get() {
				return new AttributeNotFoundException();
			}
		});
	  }

	  @PutMapping("/updateFilms/{id}")
	  Film replaceFilm(@RequestBody final Film newFilm, @PathVariable final Long id) {
	    
	    return (Film) repository.findById(id)
	      .map(new Function<Film, Object>() {
			@Override
			public Object apply(Film film) {
			    film.setTitle(newFilm.getTitle());
			    film.setAuthor(newFilm.getAuthor());
			    film.setCountry(newFilm.getCountry());
			    film.setReleaseDate(newFilm.getReleaseDate());
			    film.setCinematography(newFilm.getCinematography());
			    return repository.save(film);
			  }
		})
	      .orElseGet(new Supplier<Object>() {
			@Override
			public Object get() {
			    newFilm.setId(id);
			    return repository.save(newFilm);
			  }
		});
	  }

	  @DeleteMapping("/films/{id}")
	  void deleteFilm(@PathVariable Long id) {
		  filmService.deleteById(id);
	  }
	  
	  @DeleteMapping("/deleteFilms")
	  void deleteAllFilm() {
		  filmService.deleteAll();
	  }
	}

