package com.en.BookFilmApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.en.BookFilmApi.model.Film;
import com.en.BookFilmApi.repository.FilmRepository;

@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmRepository repository;
    
    FilmService(FilmRepository repository) {
        this.repository = repository;
      }

    @Override
    public List<Film> findAll() {
        return (List<Film>) repository.findAll();
    }

	@Override
	public Film findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Film findByTitle(String title) {
		 return repository.findByTitle(title);

		
	}

	@Override
	public Film save(Film newFilm) {
		return repository.save(newFilm);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}
}
